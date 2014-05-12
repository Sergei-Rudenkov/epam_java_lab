package by.epam.lw2.bl;

import static org.junit.Assert.*;

import org.junit.Test;

import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.flowers.decorative.Rose;
import by.epam.lw2.entity.flowers.decorative.Tulipa;
import by.epam.lw2.entity.flowers.pots.Kaktus;
import by.epam.lw2.entity.packes.Pack;
import by.epam.lw2.entity.packes.PaperPack;

public class ShopAssistentTest {
	BouquetBuielder bb = new BouquetBuielder();
	
	@Test
	public void testA() {
		Flower kaktus = new Kaktus("big", "green");
		Flower tulipa = new Tulipa("red");
		bb.flowers.add(kaktus);
		bb.flowers.add(tulipa);
		assertEquals("Sorry, are you sure? You will shuffle " + kaktus.getName() + " and " + tulipa.getName() + " flowers in your bouqet? You are crazy, man!", ShopAssistent.say(bb));
	}
	@Test
	public void testB() {
		Flower rose = new Rose("yellow");
		bb.flowers.add(rose);
		assertEquals("Sir, you are forget about pack. You are sure, you don't need?", ShopAssistent.say(bb));
	}
	
	@Test
	public void testC() {
		Flower rose = new Rose("yellow");
		Pack pack = new PaperPack();
		bb.flowers.add(rose);
		bb.pack = pack;
		assertEquals("Thank you, sir! We wait you next time!", ShopAssistent.say(bb));
	}
	
	
	

}
