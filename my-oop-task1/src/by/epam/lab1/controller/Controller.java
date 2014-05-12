package by.epam.lab1.controller;

import by.epam.lab1.bl.AddCommand;
import by.epam.lab1.bl.Command;
import by.epam.lab1.bl.SearchExpensiveCommand;
import by.epam.lab1.bl.SearchWithPricesCommand;
import by.epam.lab1.bl.ShowAllCommand;
//import by.epam.lab1.bl.ShowCommand;
import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;
import by.epam.lab1.to.TOwithPrices;
import by.epam.lab1.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Command> commands = new ArrayList<Command>();
    TO to; 
    
    
	public void run(View view){
		List<TO> returnTOList = new ArrayList<TO>();
                 Command com1 = new AddCommand(Treasure.getInstance());
                 Command com2 = new SearchExpensiveCommand(Treasure.getInstance());
                 Command com3 = new SearchWithPricesCommand(Treasure.getInstance());
                 Command com4 = new ShowAllCommand(Treasure.getInstance());
                 
                 commands.add(com1);
                 commands.add(com2);
                 commands.add(com3);
                 commands.add(com4);
                 
                 if (view.getPriceValue1() != 0){
                	 to = new TOwithPrices(view);
                 }
                 else{
                 to = new TO(view);
                 }
                // to.treasure.setName(view.getName()); 
                // to.treasure.setPrice(view.getPrice());
                 
                 int nOfCommand = view.getCommand();
                 returnTOList = commands.get(nOfCommand).execute(to);
                 view.output(returnTOList);
	}
}