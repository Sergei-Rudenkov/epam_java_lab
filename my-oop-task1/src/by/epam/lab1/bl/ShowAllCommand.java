package by.epam.lab1.bl;

import java.util.ArrayList;
import java.util.List;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.entiry.Treasury;
import by.epam.lab1.to.TO;

public class ShowAllCommand implements Command {
	
	Treasury instance;
	   
	public ShowAllCommand(Treasury instance) {
		this.instance = instance;
	}
	@Override
	public List<TO> execute(TO to) {
		List<TO> returnTOList = new ArrayList<TO>();
		
		int count = 0;
		for(Treasure tr: instance.getDepot()){
			count++;
			TO to1 = new TO();
			to1.treasure = tr;
			to1.message = " - the " + count + "th treasure from " + instance.getDepot().size();
			returnTOList.add(to1);
		}
		return returnTOList;
	}
}
