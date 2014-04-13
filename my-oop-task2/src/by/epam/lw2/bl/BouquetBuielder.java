package by.epam.lw2.bl;

import java.util.ArrayList;
import java.util.List;

import by.epam.lw2.entity.Bouquet;
import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.packes.Pack;

/**
 * 
 * @author Sergei_Rudenkov
 */
public class BouquetBuielder {
	
        public List<Flower> flowers = new ArrayList<Flower>();
        public Pack pack = null;
        
        public void addPack(Pack pack){
            if (pack!=null)
                this.pack = pack;
        }
        
        public Bouquet build() {
            if (flowers == null)
                return null;
            if (pack == null)
                return null;
            return new Bouquet(this);
        }
        
        public void addFlower(Flower flower){
        	if (flower!=null)
        	this.flowers.add(flower);
        	
        }

    }
