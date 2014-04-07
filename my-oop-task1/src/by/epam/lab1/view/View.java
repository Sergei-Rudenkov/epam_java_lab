package by.epam.lab1.view;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;
import by.epam.lab1.to.TOwithPrices;


public class View {
	
	private int commandIndex;
	private TO to;
	
	public View(int commandIndex, String name, int price){
		this.commandIndex = commandIndex;
		to = new TO();
		this.to.treasure = new Treasure(name, price);
	}
	public View(int commandIndex){
		this.commandIndex = commandIndex;
		to = new TO();
	}
	public View(int commandIndex, int price1, int price2){
		this.commandIndex = commandIndex;
		to = new TOwithPrices();
		((TOwithPrices)to).lowprice = price1;
		((TOwithPrices)to).highprice = price2;
	}
	
	
	public int getCommandIndex() {
		return commandIndex;
	}
	
	public TO getTO() {
		return to;
	}
}
