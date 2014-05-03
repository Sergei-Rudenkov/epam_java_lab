package by.epam.lw3.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.epam.lw3.entity.Car;
import by.epam.lw3.entity.Parking;

public class Runner {
	public static final int PLACES = 5;
	public static final int CARS = 8;
	static Parking parking = new Parking();
	static public ExecutorService service = Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < CARS; i++) {
			service.submit(new Car(parking, i, 4));
		}
		service.shutdown();
	}

}
