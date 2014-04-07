package by.epam.lab1.bl;

import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;

public class ShowCommand{

	public static void execute(TO to) {
		System.out.println("Show all:");
		for(int i = 0; i < Treasury.depot.size(); i++){
			System.out.println(Treasury.depot.get(i));
		}
	}
}
