package by.avramenko.classes;

import by.avramenko.classes.IFurniture;
import by.avramenko.classes.ILight;
import by.avramenko.exceptions.WrongIlluminanceException;
import by.avramenko.exceptions.WrongSpaceException;

import java.util.ArrayList;

public class Room{

    private static final int WND_ILLUMINANCE = 700;
    private static final int MAX_ILLUMINANCE = 4000;
    private static final int MAX_SPACE = 70;

    private String name;

    private int area;
    private int numberWidows;

    private ArrayList<ILight> listBulb;
    private ArrayList<IFurniture> listFurniture;

    public Room(String name, int area, int numberWidows) throws IllegalArgumentException {
        this.name = name;

        if (area > 0)
            this.area = area;
        else
            throw new IllegalArgumentException("Недопустимое значение");
        if (numberWidows > 0)
            this.numberWidows = numberWidows;
        else
            throw new IllegalArgumentException("Недопустимое значение");

        this.listBulb = new ArrayList<ILight>();
        this.listFurniture = new ArrayList<IFurniture>();
    }
    public String getName() {
        return name;
    }
    private int getIllumination(){
        int sum = WND_ILLUMINANCE * numberWidows;
        if(!listBulb.isEmpty())
        for (ILight bulb : listBulb)
            sum+=bulb.getIx();
        return sum;
    }
    private int getMinFilledArea(){
        int sum = 0;
        if(!listFurniture.isEmpty())
            for(IFurniture furniture : listFurniture)
                sum+=furniture.getArea();
        return sum;
    }
    private int getMaxFilledArea(){
        int sum = getMinFilledArea();
        if(!listFurniture.isEmpty())
            for(IFurniture furniture : listFurniture)
                if(furniture instanceof IDoubleArea)
                    sum+=((IDoubleArea) furniture).getSecondArea();
        return sum;
    }
    public void add(ILight light) throws WrongIlluminanceException {

        if (getIllumination() + light.getIx() < MAX_ILLUMINANCE)
            listBulb.add(light);
        else
            throw new WrongIlluminanceException("Недопустимое значение. Превышен лимит освещения");
    }

    public void add(IFurniture furniture) throws WrongSpaceException {

        if (100 * (this.getMaxFilledArea() + furniture.getArea()) / this.area < MAX_SPACE)
            listFurniture.add(furniture);
        else
            throw new WrongSpaceException("Недопустимое значение. Превышен лимит заполнения");
    }

    public void describe() {
        System.out.println("  " + name);
        System.out.print("    Освещенность = " + this.getIllumination());
        if(numberWidows>0)
            System.out.print(" (" + numberWidows + " "
                        + (((numberWidows % 10 >=2)&&(numberWidows % 10 <=4))?("окна "):((numberWidows % 10 == 1)?("окно "):("окон ")))
                        + "по " + WND_ILLUMINANCE + " лк");
        if(!listBulb.isEmpty())
        {
            if(listBulb.size() == 1)
                System.out.print(", лампочка ");
            else
                System.out.print(", лампочки ");

            System.out.print(listBulb.get(0).getIx() + " лк");
            for (int i = 1; i<listBulb.size();i++)
                System.out.print(" и " + listBulb.get(i).getIx() + " лк");
        }
        System.out.println(")");

        System.out.print("    Площадь = " + this.area + " м^2 (");

        if(!listFurniture.isEmpty())
        {
            System.out.print("занято "+ this.getMinFilledArea());
            if(this.getMaxFilledArea() - this.getMinFilledArea()>0)
                System.out.print("-" + this.getMaxFilledArea());

            System.out.print(" м^2, гарантированно свободно " + (this.area - this.getMaxFilledArea()) + " м^2 или ");
            if (!listFurniture.isEmpty()){
                int x = 100*(this.area - this.getMaxFilledArea())/this.area;
                System.out.print(x);
            }
            else
                System.out.print("100");
            System.out.println("% площади)");

            System.out.println("    Мебель:");
            for (IFurniture furniture : listFurniture)
                System.out.println("      " + furniture.getName() + " (площадь " + furniture.getArea() + " м^2)");
        }
        else {
            System.out.println("свободно 100%)");
            System.out.println("    Мебели нет");
        }

    }


}
