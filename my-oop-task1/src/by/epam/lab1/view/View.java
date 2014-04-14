package by.epam.lab1.view;

import java.util.List;
import by.epam.lab1.to.TO;

public class View {
    
    private int command;
    private int price;
    private String name;
    private int priceValue1;
    private int priceValue2;
    
    public View(int command, String name, int price) {
        this.command = command;
        this.name = name;
        this.price = price;
    }

    View(int command, int price1, int price2) {
        this.command = command;
        this.priceValue1 = price1;
        this.priceValue2 = price2;
        
    }
    
    View(int command){
        this.command = command;
    }

    public int getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }

    public int getCommand() {
        return command;
    }

    public void output(List<TO> toList) {
    	for(TO to : toList)
        System.out.println(to.treasure + to.message);
    }
    public int getPriceValue1() {
        return priceValue1;
    }

    public int getPriceValue2() {
        return priceValue2;
    }
    
}
