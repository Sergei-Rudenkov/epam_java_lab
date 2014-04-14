package by.epam.lab1.bl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;
import by.epam.lab1.view.Source;
import by.epam.lab1.view.View;

public class ShowAllCommandTest {
	
	View view = Source.VIEW[0]; 
	TO to = new TO(view);
	
	@Before
	public void initObjects(){
		AddCommand add = new AddCommand(Treasure.getInstance());
		add.execute(to);	
	}

	@Test
	public void test() {
		int count = 1; // we add one treasure
		ShowAllCommand showAllCommand = new ShowAllCommand(Treasure.getInstance());
		assertEquals(" - the " + count + "th treasure from " + showAllCommand.instance.getDepot().size(), showAllCommand.execute(to).get(0).message);
	}

}
