package by.epam.lw2.controller;

import by.epam.lw2.bl.BouquetBuielder;
import by.epam.lw2.bl.ShopAssistent;
import by.epam.lw2.bl.FlowerCreator;
import by.epam.lw2.bl.PackCreator;
import by.epam.lw2.entity.Bouquet;
import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.packes.Pack;
import by.epam.lw2.view.FlowerOrder;
import by.epam.lw2.view.PackOrder;
import by.epam.lw2.view.View;

public class Controller {
    
		Bouquet bouqet;
		View view;
		BouquetBuielder bouquetBuielder = new BouquetBuielder();
        
        public void run(View view){
        	this.view = view;
        	if(view instanceof FlowerOrder){
        		
        		String name = ((FlowerOrder)view).name;
        		String color = ((FlowerOrder)view).color;
        		for (FlowerCreator flowerCreator : FlowerCreator.values()){
        			if (flowerCreator.getName().equals(name)){
        				Flower flower = flowerCreator.factoryMethod(color);
        				bouquetBuielder.addFlower(flower);
        			}	
                }
        		
        	}
        	else if(view instanceof PackOrder){
        		String pack = ((PackOrder)view).pack;
        		for (PackCreator packCreator : PackCreator.values()){
        			if (packCreator.getName().equals(pack)){
        				Pack pocket = packCreator.factoryMethod();
        				bouquetBuielder.addPack(pocket);
        			}
        		}
        	}
        	
        }
        public void create(){
        	String message = ShopAssistent.say(bouquetBuielder); 
        	View.show(message);
    		bouqet = bouquetBuielder.build();
    		View.show(bouqet);
    	}
}
