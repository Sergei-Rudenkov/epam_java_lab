package by.epam.lw3.main;

import by.epam.lw3.entity.Car;
import by.epam.lw3.entity.Parking;

public class Runner {
	public static final int PLACES = 5;
	public static final int CARS = 8;
	static Parking parking = new Parking();
	
	public static void main(String[] args) {
		for(int i = 0; i < CARS; i++){
			Car car = new Car(parking, i, 4);
			Thread getPlaceOnParking = new Thread(car);
			getPlaceOnParking.start();
		}
	}

}
