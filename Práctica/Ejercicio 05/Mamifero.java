package ar.edu.unlp.info.oo1.ejercicio5;
import java.time.LocalDate;

public class Mamifero {
	
	private String id;
	private String especie;
	private LocalDate fechaNacimiento;	
	private Mamifero padre;
	private Mamifero madre;
	
	
	public Mamifero() {
		
		
	}
	
	public Mamifero(String id) {
		
		this.id = id;
	}

	
	public String getIdentificador() {
		
		return id;
	}
	
	public String getEspecie() {
		
		return especie;
	}
	
	public LocalDate getFechaNacimiento() {
		
		return fechaNacimiento;
	}
	
	public Mamifero getPadre() {
		
		return padre;
	}
	
	public Mamifero getMadre() {
		
		return madre;
	}
	
		
	public void setIdentificador(String id) {
		
		this.id = id;
	}
	
	public void setEspecie(String especie) {
		
		this.especie = especie;
	}
	
	public void setFechaNacimiento(LocalDate fecha) {
		
		this.fechaNacimiento = fecha;
	}
	
	public void setPadre(Mamifero padre) {
		
		this.padre = padre;
	}
	
	public void setMadre(Mamifero madre) {
		
		this.madre = madre;
	}
	
	
    public Mamifero getAbueloPaterno() {
		
		if (padre != null) {
			
			return padre.getPadre();
		}		
		else {
			
			return null;
		}
	}
	
	public Mamifero getAbuelaPaterna() {
		
		if (madre != null) {
			
			return padre.getMadre();
		}		
		else {
			
			return null;
		}
		
	}
	
	public Mamifero getAbueloMaterno() {
		
		if (padre != null) {
			
			return madre.getPadre();
		}		
		else {
			
			return null;
		}
		
	}
	
	public Mamifero getAbuelaMaterna() {
		
		if (madre != null) {
			
			return madre.getMadre();
		}		
		else {
			
			return null;
		}

	}
	
	public boolean tieneComoAncestroA (Mamifero unMamifero) {
		
		boolean encontre = false;
		
		if (padre != null) {
			
			if (padre.getIdentificador() == unMamifero.getIdentificador()) {
			
				encontre = true;
			}
			else {
				
				encontre = padre.tieneComoAncestroA(unMamifero);
			}
		}
		
		if ((encontre == false) && (madre != null)) {
			
			if (madre.getIdentificador() == unMamifero.getIdentificador()) {
				
				encontre = true;
			}
			else {
				
				encontre = madre.tieneComoAncestroA(unMamifero);
			}
		}
		
		return encontre;		
	}
}
