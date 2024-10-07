package ar.edu.unlp.objetos.uno.ejercicio15;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

public class UsuarioTest {

	private Usuario usuario;
	private Propiedad propiedad;
	private Reserva reserva;
	
	@BeforeEach
	public void setUp() {
		
		usuario = new Usuario("Juan", "La Plata", 12345);
		
		propiedad = new Propiedad("Estrella", "Depto", 100, "La Plata", usuario);
		
		reserva = new Reserva(LocalDate.of(2023, Month.NOVEMBER, 1),
							  LocalDate.of(2023, Month.NOVEMBER, 6),
							  propiedad, usuario);
	}
	
	/*@Test
	public void testRegistrarPropiedad() {
		
		assertEquals(usuario.getPropiedades().size(), 0);
		
		usuario.registrarPropiedad("Estrella", "Depto", 100.00, "La Plata");
		assertEquals(usuario.getPropiedades().size(), 1);
	}*/
	
	@Test
	public void testCalcularIngresos() {
		
		assertEquals(0, usuario.calcularIngresos(LocalDate.of(2023, Month.NOVEMBER, 1),
				  							  LocalDate.of(2023, Month.NOVEMBER, 6)));
		
		propiedad.getReservas().add(reserva);
		usuario.getPropiedades().add(propiedad);
		
		assertEquals(0, usuario.calcularIngresos(LocalDate.of(2023, Month.DECEMBER, 1),
				  								 LocalDate.of(2023, Month.DECEMBER, 6)));
		
		assertEquals(500, usuario.calcularIngresos(LocalDate.of(2023, Month.NOVEMBER, 1),
				  							       LocalDate.of(2023, Month.NOVEMBER, 6)));		
	}
	
	@Test
	public void testBuscarPropiedades() {
		
		assertEquals(0, usuario.buscarPropiedades(LocalDate.of(2023, Month.NOVEMBER, 1),
			       		 						  LocalDate.of(2023, Month.NOVEMBER, 6))
												  .size());		
		
		propiedad.getReservas().add(reserva);
		usuario.getPropiedades().add(propiedad);
		
		assertEquals(1, usuario.buscarPropiedades(LocalDate.of(2023, Month.NOVEMBER, 7),
												  LocalDate.of(2023, Month.NOVEMBER, 12))
												  .size());
		
	}
	
	@Test
	public void testObtenerReservas() {
		
		assertEquals(0, usuario.obtenerReservas().size());
		
		propiedad.getReservas().add(reserva);
		usuario.getPropiedades().add(propiedad);
		
		assertEquals(1, usuario.obtenerReservas().get(0).size());
	}
}
