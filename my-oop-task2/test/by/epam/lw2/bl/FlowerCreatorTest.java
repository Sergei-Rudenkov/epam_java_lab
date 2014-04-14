package by.epam.lw2.bl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.epam.lw2.entity.flowers.decorative.Rose;
import by.epam.lw2.entity.packes.PaperPack;

public class FlowerCreatorTest {
	BouquetBuielder bouquetBuielder = new BouquetBuielder();
	
	@Before
	public void initObjects(){
				bouquetBuielder.addFlower(new Rose("red"));	
				bouquetBuielder.addPack(new PaperPack());
	}
	
	@Test
	public void test() {
		
		assertEquals("Bouquet @ flowers: [red Rose], pack: paper", bouquetBuielder.build().toString());
	}

}
