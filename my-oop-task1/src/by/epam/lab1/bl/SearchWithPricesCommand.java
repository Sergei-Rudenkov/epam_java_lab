package by.epam.lab1.bl;

import java.util.ArrayList;
import java.util.List;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;
import by.epam.lab1.to.TOwithPrices;

public class SearchWithPricesCommand implements Command {
	Treasury instance;
   
	public SearchWithPricesCommand(Treasury instance) {
		this.instance = instance;
	}

	@Override
	public List<TO> execute(TO to) {
		List<TO> returnTOList = new ArrayList<TO>();
	       
			if (to instanceof TOwithPrices){ // case we looking for treasure between prices
				int maxPrice = ((TOwithPrices) to).highPrice;
				int minPrice = ((TOwithPrices) to).lowPrice;
				
                	for(int i=0; i < instance.getDepot().size(); i++){
                		int priceOFTreasure = ((Treasure) instance.getDepot().get(i)).getPrice();
                		if (priceOFTreasure < maxPrice && priceOFTreasure > minPrice ){

                			TO to1 = new TO();
                			to1.treasure = ((Treasure) instance.getDepot().get(i));
                			to1.message = " between coasts: " + minPrice + " and " + maxPrice;
                			returnTOList.add(to1);
                		}
                	}
			}
		return returnTOList;
	}
}
