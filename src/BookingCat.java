/**
 * Java.1.Lesson.5.Homework
 *
 * @autor Stanislav Lyashov
 */

import java.util.*;
import java.lang.*;

class BookingCat {
    public static void main(String[] args) {
        Random satiety = new Random();
        satiety.nextBoolean();
        int food = 30;
        Cat[] cat = {
                new Cat("Барсик", 40, satiety.nextBoolean()),
                new Cat("Семён", 30, satiety.nextBoolean()),
                new Cat("Цезарь", 20, satiety.nextBoolean()),
                new Cat("Гомер", 35, satiety.nextBoolean()),
                new Cat("Виталик", 35, satiety.nextBoolean()),
        };
        Plate plate = new Plate(100);
        plate.info();
        for (Cat cats : cat) {
            cats.info();
            cats.eat(plate);
            cats.info();
            plate.info();
        }
        plate.addFood(food);
        plate.info();
    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        int difference = food - n;
        if (difference < 0) return false;
        food -= n;
        return true;
    }

    public void addFood(int food) {
        System.out.println("Добавляем еду: " + food);
        this.food += food;
    }

    public void info() {
        System.out.println("Тарелка с едой: " + food);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void info() {
        if (!satiety) {
            System.out.println(name + " с аппетитом " + appetite);
        }
        System.out.println(name + (satiety ? " сытый" : " голодный"));
    }

    public void eat(Plate p) {
        if (satiety == false && p.decreaseFood(appetite) == true) {
            System.out.println(name + " кушает!");
            satiety = true;
        } else {
            System.out.println(name + " не смог поесть!");
        }
    }
}
