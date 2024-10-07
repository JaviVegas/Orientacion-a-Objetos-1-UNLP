package ar.edu.unlp.info.oo1.ejercicio10;

public class HighestPriority extends JobScheduler {

	public HighestPriority() {
		
		
	}
	
	public JobDescription nextito() {
		return jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
                .orElse(null);
	}
}
