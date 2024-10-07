package ar.edu.unlp.info.oo1.ejercicio6;
import java.util.List;
import java.util.ArrayList;

public class Farola {

	private boolean estado;
	public List<Farola> farolasVecinas;
	
	public Farola() {
		
		estado = false;
		farolasVecinas = new ArrayList<>();
	}
	
	// Agrega otraFarola a mi lista de vecinas, y además
	// agregame a mi a la lista de vecinas de otraFarola.
	public void pairWithNeighbor(Farola otraFarola) {
		
		farolasVecinas.add(otraFarola);
		
		otraFarola.getNeighbors().add(this);
	}
	
	
	public List<Farola> getNeighbors() {
		
		return farolasVecinas;
	}
	
	// Filtrame las farolas vecinas que están apagadas,
	// y para cada una que encontraste, mandales el mensaje turnOn().
	public void turnOn() {
		
		if (!estado) {
			
			estado = true;
			
			farolasVecinas.stream().filter(vecina -> vecina.isOn() == false)
									.forEach(vecina -> vecina.turnOn());
		}
	}
	
	// Filtrame las farolas vecinas que estén encendidas,
	// y para cada una que encontraste, mandales el mensaje turnOff().
	public void turnOff() {
		
		if (estado) {
			
			estado = false;
			
			farolasVecinas.stream().filter(vecina -> vecina.isOn())
									.forEach(vecina -> vecina.turnOff());
		}
	}
	
	public boolean isOn() {
		
		return estado;
	}	
}
