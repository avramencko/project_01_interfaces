package by.avramenko;

import by.avramenko.classes.Armcair;
import by.avramenko.classes.Building;
import by.avramenko.classes.Bulb;
import by.avramenko.classes.Desk;
import by.avramenko.exceptions.WrongIlluminanceException;
import by.avramenko.exceptions.WrongSpaceException;

public class Main {

    public static void main(String[] args) throws WrongSpaceException, WrongIlluminanceException {
        Building building = new Building("Здание 1");

        building.addRoom("Комната 1", 100, 3);
        building.addRoom("Комната 2", 5, 2);
        building.getRoom("Комната 1").add(new Bulb(150));
        building.getRoom("Комната 1").add(new Bulb(500));
        building.getRoom("Комната 1").add(new Desk("Стол письменный", 3000));
        building.getRoom("Комната 1").add(new Armcair("Кресло мягкое и пушистое", 1, 2));

        building.describe();
    }
}
