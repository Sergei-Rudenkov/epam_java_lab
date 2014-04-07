package by.epam.lab1.bl;

import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;

public class AddCommand {

		 public static void execute(TO to) {
		        	Treasury.depot.add(to.treasure);
		        	System.out.println(to.treasure + " is added.");
	}
}
