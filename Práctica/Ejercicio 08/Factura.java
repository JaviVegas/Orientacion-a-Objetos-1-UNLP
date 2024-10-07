package ar.edu.unlp.info.oo1.ejercicio8;
import java.time.LocalDate;

public class Factura {

	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		
		fecha = LocalDate.now();
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
	}
	
	
	public double getMontoEnergiaActiva() {
		
		return montoEnergiaActiva;
	}
	
	public double getDescuento() {
		
		return descuento;
	}
	
	public LocalDate getFecha() {
		
		return fecha;
	}
	
	public Usuario getUsuario() {
		
		return usuario;
	}
	
	
	public double montoTotal() {
		
		return montoEnergiaActiva - ((descuento * montoEnergiaActiva) / 100);
	}
}
