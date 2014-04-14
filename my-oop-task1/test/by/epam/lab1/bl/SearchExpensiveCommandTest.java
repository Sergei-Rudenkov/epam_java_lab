package by.epam.lab1.bl;

import static org.junit.Assert.*;

import org.junit.Test;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;

public class SearchExpensiveCommandTest {

	@Test
	public void test() {
		SearchExpensiveCommand searchExpensiveCommand = new SearchExpensiveCommand(Treasure.getInstance());
		TO to = new TO();
		searchExpensiveCommand.execute(to);
		assertEquals(" the most expensive.", to.message);
	}

}
