package ar.edu.unlp.objetos.uno.ejercicio15;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Propiedad {

	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private List<Reserva> reservas;
	private Usuario propietario;
	//private List<DateLapse> fechasOcupada;
	
	public Propiedad(String nombre, String descripcion, double precioPorNoche,
						String direccion, Usuario propietario) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioPorNoche = precioPorNoche;
		this.direccion = direccion;
		this.propietario = propietario;
		reservas = new ArrayList<>();
		//fechasOcupada = new ArrayList<>();
	}
	
	
	public double getPrecioPorNoche() {
		
		return precioPorNoche;
	}
	
	
    public List<Reserva> getReservas() {
		
		return reservas;
	}
    
    
    public Reserva hacerReserva(LocalDate fechaInicio, LocalDate fechaFin, Usuario inquilino) {
    	
    	DateLapse rangoReserva = new DateLapse(fechaInicio, fechaFin);
    	int superpuestas = (int) reservas.stream().filter(r -> r.getRangoReserva()
    															.overlaps(rangoReserva) == true)
    												.count();
    	
    	if(superpuestas == 0) {
    		
    		Reserva reserva = new Reserva(fechaInicio, fechaFin, this, inquilino);
    		reservas.add(reserva);
    		
    		return reserva;
    	}
    	else {
    		
    		return null;
    	}
    }
    
    public int buscarReservas(LocalDate fechaInicio, LocalDate fechaFin){
    	
    	DateLapse rangoFecha = new DateLapse(fechaInicio, fechaFin);
    	
    	return (int) reservas.stream().filter(r -> r.getRangoReserva().overlaps(rangoFecha) == true)
    									.count();
    }
    
    public void eliminarReserva(Reserva reserva) {
    	
    	/*if(reserva.getRangoReserva().getFrom().getDayOfYear() > LocalDate.now().getDayOfYear()) {
    		
    		reservas.remove(reserva);
    	}*/
    	
    	if(reserva.getRangoReserva().includesDate(LocalDate.now()) == false) {
    		
    		reservas.remove(reserva);
    	}  
    }
    
    public double getPrecios(LocalDate fechaInicio, LocalDate fechaFin) {
    	
    	return reservas.stream().filter(r -> (r.getRangoReserva()
    											.includesDate(fechaInicio)
    										  &&
    										  r.getRangoReserva()
    											.includesDate(fechaFin)) == true)
    							.mapToDouble(r -> r.calcularPrecio())
    							.sum();
    }
    
    public List<Reserva> obtenerReservas(Usuario inquilino) {
    	
    	return reservas.stream().filter(r -> r.getInquilino().equals(inquilino)).collect(Collectors.toList());
    }
}
