package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta {

	private double limiteDescubierto;
	
	public CuentaCorriente() {
	
		super();
	}
	
	
	public double getDescubierto() {
		
		return this.limiteDescubierto;
	}
	
	
	public void setDescubierto(double limiteDescubierto) {
		
		this.limiteDescubierto = limiteDescubierto;
	}
	
	
	public boolean puedeExtraer(double monto) {
		
		return ((this.getSaldo() > this.limiteDescubierto)
		    && ((this.getSaldo() - monto) > this.limiteDescubierto));
	}
}
