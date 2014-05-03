package by.epam.lw3.entity;

public class CarPlace { 
	volatile private boolean emp = true;
	
	public boolean isEmpty(){
		return emp;
	}
	synchronized public void setAsNonEmpty(){
		this.emp = false;
	}
	synchronized public void setAsEmpty(){
		this.emp = true;
	}
	synchronized public void stay(int time, int id) throws InterruptedException {
		System.out.println("Car id: "+ id + " is on the parking place for: " + time + " h.");
		Thread.sleep(time* 1000);
		System.out.println("Car id: "+ id + " is going out the parking");
		
	}
	
}
