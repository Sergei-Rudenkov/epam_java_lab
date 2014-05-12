package by.epam.lab1.bl;

import java.util.ArrayList;
import java.util.List;

import by.epam.lab1.to.TO;
import by.epam.lab1.entiry.Treasury;

public class AddCommand implements Command {
        
        Treasury instance;
        
        public AddCommand(Treasury instance){
            this.instance = instance;
        }

	public List<TO> execute(TO to) {
		List<TO> returnTOList = new ArrayList<TO>();
            instance.getDepot().add(to.treasure);
            to.message = " is added.";
            returnTOList.add(to);
            return returnTOList;
    }

}
