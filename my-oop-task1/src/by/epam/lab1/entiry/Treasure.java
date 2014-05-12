package by.epam.lab1.entiry;

public class Treasure {
	
	public int price;
	private String name;
        private static Treasury instance;
        
        static{
            instance = new Treasury();
        }
	
	 public Treasure(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }

    public Treasure() {
       
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
            public static Treasury getInstance() {
	        return instance;
	    }
}
