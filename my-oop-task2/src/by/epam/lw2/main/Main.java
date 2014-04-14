package by.epam.lw2.main;

import by.epam.lw2.controller.Controller;
import by.epam.lw2.view.Source;
import by.epam.lw2.view.View;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		for (View view : Source.VIEW){
			controller.run(view);
		}
		controller.create();
	}
}
