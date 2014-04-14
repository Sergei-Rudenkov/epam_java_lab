package by.epam.lab1.bl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.lab1.entiry.Treasure;
import by.epam.lab1.to.TO;
import by.epam.lab1.to.TOwithPrices;
import by.epam.lab1.view.Source;
import by.epam.lab1.view.View;

public class SearchWithPricesCommandTest {
	View view2 = Source.VIEW[2]; 
	View view5 = Source.VIEW[5];
	@Before
	public void initObjects(){
		AddCommand add = new AddCommand(Treasure.getInstance());
		TO to2 = new TO(view2);
		add.execute(to2);
	}
	@Test
	public void test() {
		SearchWithPricesCommand searchWithPricesCommand = new SearchWithPricesCommand(Treasure.getInstance());
		TOwithPrices to = new TOwithPrices(view5);
		
		assertEquals(" between coasts: " + view5.getPriceValue1() + " and " + view5.getPriceValue2(), searchWithPricesCommand.execute(to).get(0).message);
	}

}
