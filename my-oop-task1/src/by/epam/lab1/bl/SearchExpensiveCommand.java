package by.epam.lab1.bl;

import java.util.ArrayList;
import java.util.List;
import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;

public class SearchExpensiveCommand implements Command {
        Treasury instance;
        public SearchExpensiveCommand(Treasury instance){
            this.instance = instance;
        }
    @Override
    public List<TO> execute(TO to) {
        List<TO> returnTOList = new ArrayList<TO>();
                int maxPrice = 0;
                    for(int i=0; i < instance.getDepot().size(); i++){
                        if (maxPrice < ((Treasure) instance.getDepot().get(i)).getPrice()){
                            to.treasure = (Treasure) instance.getDepot().get(i);
                                  maxPrice = ((Treasure) instance.getDepot().get(i)).getPrice();
                        }
                    }
            to.message = " the most expensive.";
            returnTOList.add(to);
        return returnTOList;
    }
}
    
    

