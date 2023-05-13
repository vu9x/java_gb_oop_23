package seminars.s4.homeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class hw {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<Apple>(new ArrayList<>(Arrays.asList(new Apple(), new Apple(), new Apple())), "Яблок");
        Box<Apple> appleBox2 = new Box<Apple>(new ArrayList<>(Arrays.asList(new Apple(), new Apple())), "Яблок");
        Box<Orange> orangeBox1 = new Box<Orange>(new ArrayList<>(Arrays.asList(new Orange(), new Orange())), "Апельсинов");

        System.out.println(appleBox1.compare(orangeBox1));
        System.out.println("__________________");
        System.out.println(appleBox2.compare(orangeBox1));

        System.out.println("Добавляем апельсин в коробку:");
        System.out.println(orangeBox1);
        orangeBox1.addFruit(new Orange());
        System.out.println(orangeBox1);

        System.out.println("__________________");
        appleBox1.addFruitsFromBox(appleBox2);



    }
}

abstract class Fruit{
    private final double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    // @Override
    // public String toString() {
    //     return super.toString();
    // }

}

class Apple extends Fruit{

    public Apple(){
        super(1.0f);
    }

    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub
    //     return "Яблоко";
    // }
}

class Orange extends Fruit{

    public Orange(){
        super(1.5f);
    }

    // @Override
    // public String toString() {
    //     // TODO Auto-generated method stub
    //     return "Апельсин";
    // }
}

class Box<T extends Fruit>{
    // коллекция
    private ArrayList<T> fruits;
    private double weight;
    private String name;

    public Box(ArrayList<T> fruits, String name) {
        this.fruits = fruits;
        this.name = name;
        
    }


    /**
     * Метод добавление фрукта в коробку
     * @param fruit фрукт
     */
    public void addFruit(T fruit){
        fruits.add(fruit);
        this.weight += fruit.getWeight();
    }

    public List<T> getFruits() {
        return fruits;
    }

    /**
     * Метод получение веса коробки
     * @return возвращает вес коробки
     */
    public double getWeight() {
        weight = 0;
        for(T fruit : fruits) {
            this.weight += fruit.getWeight();
        }
        return weight;
    }

    public void emtyBox(){
        this.weight = 0;
        this.name = null;
        this.fruits.clear();
    }

    /**
     * Метод сравнивания 2х коробок
     * @param otherBox другая коробка
     * @return если Box=otherBox возвращает true; иначе false
     */
    public boolean compare(Box otherBox) {
        if(getWeight() == otherBox.getWeight()){
            System.out.printf("Коробки равны:\n%s \n%s\n", toString(), otherBox.toString());
            return true;
        } else {
            System.out.printf("Коробки не равны:\n%s \n%s\n", toString(), otherBox.toString());
            return false;
        }
    }

    /**
     * Метод пересыпание фруктов
     * @param o1 коробка 1, куда пересыпать
     * @param o2 коробка 2, от куда отсыпаем
     */
    public void addFruitsFromBox(Box<T> otherBox){
        System.out.printf("В коробке 1: %s\n", toString());
        System.out.printf("В коробке 2: %s\n", otherBox.toString());
        getFruits().addAll(otherBox.getFruits());
        getWeight();

        otherBox.emtyBox();
        System.out.println("Успешно пересыпали");
        System.out.printf("В коробке 1: %s\n", toString());
        System.out.printf("В коробке 2: %s\n", otherBox.toString());
        
    }

    @Override
    public String toString() {
        return String.format("Коробка: %s, количество: %d, вес: %.2f\n", name, fruits.size(), getWeight());
    }

    
}

