package ar.edu.unlp.objetos.uno.ejercicio15;
import java.util.*;
import java.time.*;

public class OOBnB {

	private List<Usuario> usuarios;
	
	public OOBnB() {
		
		usuarios = new ArrayList<>();
	}
	
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		
		Usuario usuario = new Usuario(nombre, direccion, dni);
		usuarios.add(usuario);
		
		return usuario;
	}
	
	
	public List<Propiedad> buscarPropiedades(LocalDate fechaInicio, LocalDate fechaFin) {
		
		return usuarios.stream().map(u -> u.buscarPropiedades(fechaInicio, fechaFin)).collect(null);
	}
	
	
}
