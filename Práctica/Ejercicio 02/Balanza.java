package ar.edu.unlp.info.oo1.ejercicio2;
import java.util.List;
import java.util.ArrayList;

public class Balanza {
	
	private List<Producto> productos;
	/*private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;*/
	
	public Balanza() {
		
		productos = new ArrayList<>();
		/*cantidadDeProductos = 0;
		precioTotal = 0;
		pesoTotal = 0;*/
	}
	
	
	public List<Producto> getProductos(){
		
		return productos;
	}	
	
	public int getCantidadDeProductos() {
		
		return productos.size();
	}
	
	public double getPrecioTotal() {
		
		double precio = productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
		
		return precio;
	}
	
	public double getPesoTotal() {
		
		double peso = productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
		
		return peso;
	}
	
	
	public void ponerEnCero() {
		
		productos.clear();
		/*cantidadDeProductos = 0;
		precioTotal = 0;
		pesoTotal = 0;*/
	}
	
	public void agregarProducto(Producto producto) {
		
		productos.add(producto);
		/*cantidadDeProductos += 1;
		precioTotal += producto.getPrecio();
		pesoTotal += producto.getPeso();*/
	}
	
	public Ticket emitirTicket() {
		
		Ticket ticket = new Ticket(productos);	
		
		return ticket;
	}
}
