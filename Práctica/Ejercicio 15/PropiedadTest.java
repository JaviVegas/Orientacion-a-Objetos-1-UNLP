package ar.edu.unlp.objetos.uno.ejercicio15;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {

	private Propiedad propiedad;
	private Usuario usuario;
	private Reserva reserva;
	
	@BeforeEach
	public void setUp() {
		
		usuario = new Usuario("Juan", "La Plata", 12345);
		
		propiedad = new Propiedad("Estrella", "Depto", 100, "La Plata", usuario);
		
		reserva = new Reserva(LocalDate.of(2023, Month.NOVEMBER, 1),
							  LocalDate.of(2023, Month.NOVEMBER, 6),
							  propiedad, usuario);
	}
	
	
}
