package by.epam.lab1.bl;
import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;
import by.epam.lab1.to.TOwithPrices;

public class SearchCommand{

	public static TO execute(TO to) {
		if (to instanceof TOwithPrices){ // case we looking for treasure between prices
			
			int maxPrice = ((TOwithPrices) to).highprice;
			int minPrice = ((TOwithPrices) to).lowprice;
			
			for(int i=0; i < Treasury.depot.size(); i++){
				if (Treasury.depot.get(i).getPrice() < maxPrice && Treasury.depot.get(i).getPrice() > minPrice ){
					System.out.println(" Between prices: " + minPrice + " and " + maxPrice + " - " + Treasury.depot.get(i));
				}
			}
			
		}else{  // case we are looking for the most expensive
			int maxPrice = 0; 
		    for(int i=0; i < Treasury.depot.size(); i++){
	    	  if (maxPrice < Treasury.depot.get(i).getPrice()){
					  to.treasure = Treasury.depot.get(i);
					  maxPrice = Treasury.depot.get(i).getPrice();
				  }
			  }
			  System.out.println("max price = " + to.treasure);
		
		}
		return to;
	}

}
