package by.avramenko.classes;

public class Desk implements IFurniture {

    private String name;
    private int area;

    public Desk(String name, int area){
        this.name = name;
        this.area = area;
    }
    @Override
    public Integer getArea() {
        return area;
    }

    @Override
    public String getName() {
        return name;
    }
}
