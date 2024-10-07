package ar.edu.unlp.info.oo1.ejercicio10;

public class FIFO extends JobScheduler {
	
	public FIFO() {
		
		
	}
	
	public JobDescription nextito() {
        return jobs.get(0);
	}
}
