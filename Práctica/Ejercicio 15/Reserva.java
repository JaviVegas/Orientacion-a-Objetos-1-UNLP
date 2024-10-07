package ar.edu.unlp.objetos.uno.ejercicio15;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Reserva {

	private DateLapse rangoReserva;
	private Propiedad propiedad;
	private Usuario inquilino;
	
	public Reserva(LocalDate fechaInicio, LocalDate fechaFin,
					Propiedad propiedad, Usuario inquilino) {
		
		rangoReserva = new DateLapse(fechaInicio, fechaFin);
		this.propiedad = propiedad;
		this.inquilino = inquilino;
	}
	
	
	public DateLapse getRangoReserva() {
		
		return rangoReserva;
	}
	
	public Propiedad getPropiedad() {
		
		return propiedad;
	}
	
	public Usuario getInquilino() {
		
		return inquilino;
	}
	
	public double calcularPrecio() {
		
		return propiedad.getPrecioPorNoche() * rangoReserva.sizeInDays();
	}
	
	
}
