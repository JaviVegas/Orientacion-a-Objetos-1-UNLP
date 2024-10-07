package ar.edu.unlp.objetos.uno.ejercicio15;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateLapse {

	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	public DateLapse(LocalDate fechaInicio, LocalDate fechaFin) {
		
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
	//“Retorna la fecha de inicio del rango”
	public LocalDate getFrom() {
		
		return fechaInicio;
	}
	
	//“Retorna la fecha de fin del rango”
	public LocalDate getTo() {
		
		return fechaFin;
	}
	
	//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
	public int sizeInDays() {
		
		return (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
		
		
		//return fechaFin.getDayOfYear() - fechaInicio.getDayOfYear();
	}
	
	//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to
	//del receptor y false en caso contrario”.
	public boolean includesDate(LocalDate other) {
		
		//return fechaInicio.isBefore(other) && other.isBefore(fechaFin);
		//NOTA RANDOM: other.minusYears(1) -> 1 año atras de "other".
		other.
		return !(other.isBefore(fechaInicio) || fechaFin.isBefore(other));
	}
	
	
	/**
	Retorna true si el período de tiempo del receptor se superpone con el
	recibido por parámetro
	**/
	public boolean overlaps (DateLapse anotherDateLapse) {
		
		return !(anotherDateLapse.getTo().isBefore(fechaInicio) || anotherDateLapse.getFrom().isAfter(fechaFin));
		//return (fechaInicio.isAfter(anotherDateLapse.getFrom()) && fechaInicio.isBefore(anotherDateLapse.getTo()))
		//		|| (fechaFin.isAfter(anotherDateLapse.getFrom()) && fechaFin.isBefore(anotherDateLapse.getTo()));
	}
	
}
