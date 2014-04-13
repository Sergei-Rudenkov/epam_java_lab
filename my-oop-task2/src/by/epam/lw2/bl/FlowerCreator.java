package by.epam.lw2.bl;

import by.epam.lw2.entity.flowers.*;
import by.epam.lw2.entity.flowers.decorative.Chrysanthemum;
import by.epam.lw2.entity.flowers.decorative.Gerbera;
import by.epam.lw2.entity.flowers.decorative.Orchid;
import by.epam.lw2.entity.flowers.decorative.Rose;
import by.epam.lw2.entity.flowers.decorative.Tulipa;
import by.epam.lw2.entity.flowers.pots.Kaktus;
import by.epam.lw2.entity.flowers.wild.BellFlower;
import by.epam.lw2.entity.flowers.wild.Camomile;
import by.epam.lw2.entity.flowers.wild.Lupin;


public enum FlowerCreator {
    ROSECREATOR("rose"),
    TULIPACREATOR("tulipa"),
    GERBERACREATOR("gerbera"),
    CHRYSANTHEMUMCREATOR("chrysanthemum"),
    CAMOMILECREATOR("camomile"),
    KAKTUSCREATOR("kaktus"),
    LUPINCREATOR("lupin"),
    BELLFLOWER("bell flower"),
    ORCHIDCREATOR("orchid");
    


    private String name;

    public String getName() {
        return name;
    }

    FlowerCreator(String name){
        this.name = name;
    }

    public Flower factoryMethod(String color) {
        switch (this) {
            case ROSECREATOR:
                return new Rose(color);
            case TULIPACREATOR:
                return new Tulipa(color);
            case GERBERACREATOR:
                return new Gerbera(color);
            case CHRYSANTHEMUMCREATOR:
                return new Chrysanthemum(color);
            case CAMOMILECREATOR:
                return new Camomile(color);
            case BELLFLOWER:
                return new BellFlower(color);
            case KAKTUSCREATOR:
                return new Kaktus(color);
            case LUPINCREATOR:
                return new Lupin(color);
            case ORCHIDCREATOR:
                return new Orchid(color);
                
        }
        return null;
    }

}

