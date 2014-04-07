package by.epam.lab1.entiry;

public class Treasure {
	
	private int price;
	private String name;
	
	 public Treasure(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

	    public int getPrice(){
	        return price;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public String toString(){
	    	return name + "  " + price;
	    }
}
