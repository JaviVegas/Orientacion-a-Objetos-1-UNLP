package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.*;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKWh;
	private List<Usuario> usuarios;
	
	public Distribuidora(double precioKWh) {
		
		this.precioKWh = precioKWh;
		usuarios = new ArrayList<>();
	}
	
	
	public double getPrecioKW() {
		
		return precioKWh;
	}
	
	public List<Usuario> getUsuarios(){
		
		return usuarios;
	}

	
	public void setPrecioKWh(double precioKWh) {
		
		this.precioKWh = precioKWh;
	}
	
	public void agregarUsuario (Usuario usuario) {
		
		Usuario user = usuarios.stream().filter(u -> u.getNombre() == usuario.getNombre())
						 .findAny().orElse(null);
		
		if (user == null) {
			
			usuarios.add(usuario);
		}
	}
	
	public double consumoTotalActiva() {
		
		List<Double> listaTotal = usuarios.stream().map(usuario -> usuario.getConsumos()
							   .stream().mapToDouble(consumo -> consumo.getConsumoEnergiaActiva())
							   .sum()).collect(Collectors.toList());
		
		double total = 0;
		
		for (int i= 0; i< listaTotal.size(); i++) {
			
			System.out.println("Valor " + listaTotal.get(i));
			total = total + listaTotal.get(i);
		}
		
		System.out.println(total);
		return total;
	}
	
	public List<Factura> facturar() {
		
		return usuarios.stream().map(usuario -> usuario.facturarEnBaseA(precioKWh))
								.collect(Collectors.toList());
	}
}
