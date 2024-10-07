package ar.edu.unlp.info.oo1.ejercicio2;
import java.time.LocalDate;
import java.util.List;

public class Ticket {

	private LocalDate fecha;
	private List<Producto> productos;
	/*private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;*/
	
	public Ticket(List <Producto> productos) {
		
		fecha = LocalDate.now();
		this.productos = productos;
		/*this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;*/
	}
	
	
	public LocalDate getFecha() {
		
		return fecha;
	}
	
	public List<Producto> getProductos() {
		
		return productos;
	}
	
	public int getCantidadDeProductos() {
		
		return productos.size();
	}
	
	public double getPesoTotal() {
		
		double peso = productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
		
		return peso;
	}
	
	public double getPrecioTotal() {
		
		double precio = productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
		
		return precio;
	}
	
	
	public void setFecha(LocalDate fecha) {
		
		this.fecha = fecha;
	}
	
	/*public void setCantidadDeProductos(int cantidadDeProductos) {
		
		this.cantidadDeProductos = cantidadDeProductos;
	}
	
	public void setPesoTotal(double pesoTotal) {
		
		this.pesoTotal = pesoTotal;
	}
	
	public void setPrecioTotal(double precioTotal) {
		
		this.precioTotal = precioTotal;
	}*/
	
	
	public double impuesto() {
		
		return getPrecioTotal() * 0.21;
	}
}
