package by.epam.lab1.bl;

import static org.junit.Assert.*;
import org.junit.Test;

import by.epam.lab1.bl.AddCommand;
import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;

public class AddCommandTest {
	
	AddCommand addCommand = new AddCommand(Treasure.getInstance());
	TO to = new TO();
	
	@Test
	public void testA() {
		addCommand.execute(to);
		assertEquals(" is added.", to.message);
	}
	@Test
	public void testB() {
		addCommand.execute(to);
		to.treasure = new Treasure("Ruby", 100);
		assertEquals("Ruby  100", to.treasure.toString());
	}

}
