package by.avramenko.classes;

public class Armcair implements IDoubleArea {

    private String name;
    private int area1;
    private int area2;

    public Armcair(String name, int area1, int area2){
        this.name = name;
        this.area1 = area1;
        this.area2 = area2;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getArea() {
        return area1;
    }

    @Override
    public Integer getSecondArea() {
        return area2;
    }
}
