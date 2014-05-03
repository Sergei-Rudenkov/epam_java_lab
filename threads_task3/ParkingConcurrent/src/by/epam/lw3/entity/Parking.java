package by.epam.lw3.entity;


import java.util.concurrent.TimeUnit;

import by.epam.lw3.main.Runner;

public class Parking {

	private CarPlace[] instance = new CarPlace[Runner.PLACES];
	{
		initParking();
	}

	public void getPlace(int idNumber, int stayTime) throws InterruptedException {
		int place = placeSearcher();
		
		if (!instance[place].isEmpty()) {	
			try {
				System.out.println("Car number " + idNumber
						+ " is trying to get place on the parking.");
				if (instance[place].getPermission().tryLock(1000, TimeUnit.MILLISECONDS)) {
					System.out.println("Car number " + idNumber
							+ " got place for:" + stayTime + " h.");
					instance[place].getPermission().lock();
					Thread.sleep(stayTime * 1000);
				} else {
					System.out.println("Car number " + idNumber
							+ " have not got place.");
				}

			} finally {
				instance[place].setAsEmpty();
				instance[place].getPermission().unlock();

			}
		} else {
			System.out.println("No places, sorry.");
		}
	}
	private void initParking() {
		for(int i = 0; i < instance.length; i++){
			instance[i] = new CarPlace();
		}
		
	}
	synchronized private int placeSearcher(){
		for (int i = 0; i < instance.length; i++) {
			if(instance[i].isEmpty()){
				instance[i].setAsNonEmpty();
				System.out.println("Free place: " + i);
				return i;
			}
		}	
		return 0;
	}	
}
