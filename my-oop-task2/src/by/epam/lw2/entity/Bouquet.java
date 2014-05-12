package by.epam.lw2.entity;

import by.epam.lw2.bl.BouquetBuielder;
import by.epam.lw2.entity.flowers.Flower;
import by.epam.lw2.entity.packes.Pack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Вероника
 * Date: 08.03.14
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */

public class Bouquet {
    private List<Flower> flowers = new ArrayList<Flower>();
    private Pack pack = null;

    

    public Bouquet(BouquetBuielder builder) {
        this.flowers = builder.flowers;
        this.pack = builder.pack;
    }

    @Override
    public String toString() {
        return "Bouquet @ " +
                    "flowers: " + flowers +
                    ", pack: " + pack;
    }
}
