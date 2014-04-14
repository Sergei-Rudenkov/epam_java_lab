package by.epam.lw2.controller;

import by.epam.lw2.bl.BouquetBuielder;
import by.epam.lw2.bl.ShopAssistent;
import by.epam.lw2.bl.FlowerCreator;
import by.epam.lw2.bl.PackCreator;
import by.epam.lw2.entity.Bouquet;
import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.packes.Pack;
import by.epam.lw2.view.View;
import by.epam.lw2.view.flowerorder.FlowerOrder;
import by.epam.lw2.view.flowerorder.PotsFlOrder;
import by.epam.lw2.view.flowerorder.WildFlOrder;
import by.epam.lw2.view.packorder.PackOrder;

public class Controller {
    
		Bouquet bouqet;
		View view;
		BouquetBuielder bouquetBuielder = new BouquetBuielder();
        
        public void run(View view){
        	this.view = view;
        	
        	if(view instanceof PotsFlOrder){
        		String name = ((FlowerOrder)view).name;
        		String color = ((FlowerOrder)view).color;
        		String size = ((PotsFlOrder)view).size;
        		for (FlowerCreator flowerCreator : FlowerCreator.values()){
        			if (flowerCreator.getName().equals(name)){
        				Flower flower = flowerCreator.factoryMethod(color,size);
        				bouquetBuielder.addFlower(flower);
        			}	
                }
        		
        	}
        	
        	else if(view instanceof WildFlOrder){
        		String name = ((FlowerOrder)view).name;
        		String color = ((FlowerOrder)view).color;
        		int length = ((WildFlOrder)view).brenchLength;
        		for (FlowerCreator flowerCreator : FlowerCreator.values()){
        			if (flowerCreator.getName().equals(name)){
        				Flower flower = flowerCreator.factoryMethod(color, length);
        				bouquetBuielder.addFlower(flower);
        			}	
                }
        		
        	}
        	
        	else if(view instanceof FlowerOrder){
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
