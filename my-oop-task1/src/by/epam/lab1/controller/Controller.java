package by.epam.lab1.controller;

import by.epam.lab1.bl.AddCommand;
import by.epam.lab1.bl.Commands;
import by.epam.lab1.bl.SearchCommand;
import by.epam.lab1.bl.ShowCommand;
import by.epam.lab1.view.StaticFinal;
import by.epam.lab1.view.View;

public class Controller {
	public static void run(){
			View[] view = StaticFinal.VIEW;
			for (int i = 0; i < view.length; i++){
			if (Commands.getByIndex(view[i].getCommandIndex()) == Commands.ADD){  // 3
				AddCommand.execute(view[i].getTO());
			}else if (Commands.getByIndex(view[i].getCommandIndex()) == Commands.SEARCH){ // 2
				SearchCommand.execute(view[i].getTO());
			}else if (Commands.getByIndex(view[i].getCommandIndex()) == Commands.SHOW){  // 1
				ShowCommand.execute(view[i].getTO());
			}
		}
	}
}