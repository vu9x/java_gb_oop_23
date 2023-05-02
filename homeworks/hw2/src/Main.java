// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik1", 5);
        Plate plate = new Plate(100);
        plate.info();
//        cat1.eat();
//        plate.setFood(plate.getFood() - cat1.getAppetite());

        Cat[] cats = {
                cat1,
                new Cat("Barsik2", 10),
                new Cat("Barsik3", 15),
                new Cat("Barsik4", 20),
                new Cat("Barsik5", 25),
                new Cat("Barsik6", 30),
                new Cat("Barsik7", 35)
        };

        for (Cat cat: cats) {
            if((plate.getFood() - cat.getAppetite()) >= 0){
                cat.eat();
                System.out.printf("%s is full = %b\n", cat.getName(), cat.getFull());
                plate.setFood(plate.getFood() - cat.getAppetite());
            } else {
                plate.addFood();
                cat.eat();
                System.out.printf("%s is full = %b\n", cat.getName(), cat.getFull());
            }
        }
    }
}