package ar.edu.unlp.info.oo1.ejercicio3;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {

	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String miCliente) {
		
		fecha = LocalDate.now();
		cliente = miCliente;
		items = new ArrayList<>();
	}
	
	
	public LocalDate getFecha() {
		
		return fecha;
	}
	
	public String getCliente() {
		
		return cliente;
	}
	
	
	public void agregarItem(Item item) {
		
		items.add(item);
	}
	
	public double calcularTotal() {
		
		double total = items.stream().mapToDouble(item -> item.costo()).sum();
		
		return total;
	}
}
