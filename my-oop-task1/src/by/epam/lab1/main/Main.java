package by.epam.lab1.main;
import by.epam.lab1.controller.Controller;
import by.epam.lab1.view.View;
import by.epam.lab1.view.Source;

public class Main {

	public static void main(String[] args) {
                Controller controller = new Controller();
                for(View view : Source.VIEW){
                	controller.run(view);
                }
	}

}
