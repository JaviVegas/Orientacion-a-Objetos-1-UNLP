package ar.edu.unlp.info.oo1.ejercicio4;

public class Cuerpo3D {

	private double altura;
	private Figura caraBasal;
	
	public Cuerpo3D() {
		
		
	}
	
	
	public double getAltura() {
		
		return altura;
	}
	
	
	public void setAltura(double altura) {
		
		this.altura = altura;
	}
	
	
	public void setCaraBasal(Figura caraBasal) {
		
		this.caraBasal = caraBasal;
	}
	
	
	public double getSuperficieExterior() {
		
		return (caraBasal.getArea() * 2) + (caraBasal.getPerimetro() * altura);
		
	}
	
	public double getVolumen() {
		
		return caraBasal.getArea() * altura;
	}
}
