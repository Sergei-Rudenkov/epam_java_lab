package by.epam.lw2.entity.flowers;

public abstract class Flower {
    protected String name;
    private String color;

    public String getName() {
        return name;
    }

    public Flower(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " " + getName();
    }
}