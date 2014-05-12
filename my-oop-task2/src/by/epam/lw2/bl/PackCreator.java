package by.epam.lw2.bl;

import by.epam.lw2.entity.packes.BasketPack;
import by.epam.lw2.entity.packes.Pack;
import by.epam.lw2.entity.packes.PaperPack;
import by.epam.lw2.entity.packes.RibbonPack;

/**
 * Created with IntelliJ IDEA.
 * User: Вероника
 * Date: 08.03.14
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public enum  PackCreator {
    PAPERCREATOR("paper"), RIBBONCREATOR("ribbon"), BASKETCREATOR("basket");

    public String getName() {
        return name;
    }

    private String name;

    PackCreator(String name){
        this.name = name;
    }

    public Pack factoryMethod() {
        switch (this){
            case PAPERCREATOR:
                return new PaperPack();
            case RIBBONCREATOR:
                return new RibbonPack();
            case BASKETCREATOR:
                return new BasketPack();
        }
        return null;
    }
}
