package by.avramenko.classes;

public class Bulb implements ILight {

    private int lx;

    public Bulb(int lx){
        this.lx = lx;
    }
    @Override
    public Integer getIx() {
        return lx;
    }
}
