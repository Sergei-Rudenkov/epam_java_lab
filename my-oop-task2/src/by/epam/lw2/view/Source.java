package by.epam.lw2.view;

import by.epam.lw2.view.flowerorder.FlowerOrder;
import by.epam.lw2.view.flowerorder.PotsFlOrder;
import by.epam.lw2.view.flowerorder.WildFlOrder;
import by.epam.lw2.view.packorder.PackOrder;

public class Source {
	
	public static View[] VIEW = {new FlowerOrder("rose", "red"), new FlowerOrder("rose", "red"), new PotsFlOrder("kaktus", "green", "big"), new WildFlOrder("lupin", "blue", 25), new PackOrder("paper")};

}
