package by.epam.lw2.entity.packes;

/**
 * Created with IntelliJ IDEA.
 * User: Вероника
 * Date: 08.03.14
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pack {
    String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
