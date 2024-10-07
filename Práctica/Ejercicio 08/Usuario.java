package ar.edu.unlp.info.oo1.ejercicio8;
import java.util.*;

public class Usuario {

	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		
		this.nombre = nombre;
		this.domicilio = domicilio;
		facturas = new ArrayList<>();
		consumos = new ArrayList<>();
	}
	
	
	public String getDomicilio() {
		
		return domicilio;
	}
	
	public String getNombre() {
		
		return nombre;
	}
	
	public List<Factura> getFacturas(){
		
		return facturas;
	}
	
	public List<Consumo> getConsumos(){
		
		return consumos;
	}
	
	
	public void agregarMedicion(Consumo consumo) {
		
		consumos.add(consumo);
	}
	
	public double ultimoConsumoActiva() {
		
		return consumos.stream().max((c1, c2) -> c1.getFecha().compareTo(c2.getFecha()))
								.map((consumo) -> consumo.getConsumoEnergiaActiva())
								.orElse(0.0);
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		
		Consumo ultimo = this.ultimoConsumo();
		if (ultimo == null) {
			
			return new Factura(0,0,this);
		}
		
		double descuento = 0;
		if(ultimo.factorDePotencia() >= 0.8) {
			
			descuento = 10;
		}
		
		return new Factura(ultimo.costoEnBaseA(precioKWh), descuento, this);
	}
	
	public List<Factura> facturas() {
		
		return facturas;
	}
	
	public Consumo ultimoConsumo() {
		
		return consumos.stream()
					   .max((c1, c2) -> c1.getFecha().compareTo(c2.getFecha()))
				       .orElse(null);
	}
}
