package ar.edu.unlp.objetos.uno.ejercicio15;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Usuario {

	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, int dni) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		propiedades = new ArrayList<>();
	}
	
	
	public String getNombre() {
		
		return nombre;
	}	
	
	public List<Propiedad> getPropiedades() {
		
		return propiedades;
	}	
	
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioPorNoche,
			String direccion) {
		
		Propiedad propiedad = new Propiedad(nombre, descripcion, precioPorNoche, direccion, this);
		propiedades.add(propiedad);
		
		return propiedad;
	}
	
	public List<Propiedad> buscarPropiedades(LocalDate fechaInicio, LocalDate fechaFin){
		
		return propiedades.stream().filter(p -> p.buscarReservas(fechaInicio, fechaFin) == 0)
									.collect(Collectors.toList());
	}
	
	public List<Reserva> obtenerReservas() {
		
		return propiedades.stream().flatMap(p -> p.obtenerReservas(this).stream()).collect(Collectors.toList());
	}
	
	public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return (double) propiedades.stream().mapToDouble(p -> p.getPrecios(fechaInicio, fechaFin))
											.sum();
	}
}
