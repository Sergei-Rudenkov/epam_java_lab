package by.epam.lw3.entity;

public class Car implements Runnable {
	
	private Parking parking;
	private int idNumber;
	private int stayTime;
	
	public Car(Parking parking, int id, int stayTime){
		this.parking = parking;
		this.idNumber = id;
		this.stayTime = stayTime;
	}
	
	@Override
	public void run() {
		try {
			parking.getPlace(idNumber, stayTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
