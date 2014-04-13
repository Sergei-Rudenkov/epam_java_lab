package by.epam.lw2.bl;

import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.flowers.decorative.DecorativeFlowers;
import by.epam.lw2.entity.flowers.pots.PotsFlowers;
import by.epam.lw2.entity.flowers.wild.WildFlower;

public class ShopAssistent {
	Flower bouquetType;
	public static String say(BouquetBuielder bouquetBuielder){
		for(Flower flower : bouquetBuielder.flowers){
			for(Flower bloom : bouquetBuielder.flowers){
				if(flower instanceof DecorativeFlowers && bloom instanceof PotsFlowers || flower instanceof WildFlower && bloom instanceof PotsFlowers ){
					return "Sorry, are you sure? You will shuffle " + bloom.getName() + " and " + flower.getName() + " flowers in your bouqet? You are crazy, man!";
				}
			}
		}
		
		if(bouquetBuielder.pack == null){
			return "Sir, you are forget about pack. You are sure, you don't need?";
		}
		
		return "Thank you, sir! We wait you next time!";
		
	}

}
