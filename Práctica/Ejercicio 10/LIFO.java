package ar.edu.unlp.info.oo1.ejercicio10;

public class LIFO extends JobScheduler{
	
	public LIFO() {
	
		
	}
	
	public JobDescription nextito() {
		
		return jobs.get(jobs.size()-1);
	}

}
