package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {
	
	public CajaDeAhorro() {
		
		super();
	}
	
	
	public boolean puedeExtraer(double monto) {
		
		return ((this.getSaldo() > 0) && (this.getSaldo() >= monto));
	}
	
	public void extraerSinControlar(double monto) {
		
		super.extraerSinControlar(agregarAdicional(monto));
	}
	
	public void depositar(double monto) {
		
		super.depositar(quitarAdicional(monto));
	}
	
	public double agregarAdicional(double monto) {
		
		return monto * 1.02;
	}
	
	public double quitarAdicional(double monto) {
		
		return monto * 0.98;
	}
}
