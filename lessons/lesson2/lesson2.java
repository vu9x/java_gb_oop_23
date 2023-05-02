public class lesson2 {
    public static void main(String[] args) {
        
        Cat cat1 = new Cat("Барсик", "Белый");
        cat1.jump();
        cat1.voice();
        System.out.printf("Цвет котика: %s\n", cat1.getColor());
        System.out.printf("Имя котика: %s\n", cat1.getName()); // одинаково
        System.out.printf("Имя котика: %s\n", ((Animal)cat1).getName()); // одинаково

        Dog dog1 = new Dog("Рекс", 9);
        dog1.jump();
        dog1.voice();
        System.out.printf("Вес собаки: %d\n", dog1.getWeight());

        Animal cat2 = new Cat("Персик", "Рыжий");
        cat2.jump();
        cat2.voice();
        if (cat2 instanceof Dog) {
            System.out.printf("Цвет котика: %s\n", ((Dog)cat2).getWeight());
        }
        System.out.printf("Цвет котика: %s\n", ((Cat)cat2).getColor());

        voiceAllAnimal(new Animal[] {cat1, dog1, cat2});

        CatV2 catV2 = new CatV2("Барсик");
        Runable catV2_2 = new CatV2("Барсик 2"); // Создаем экземпляр объекта от интерфейса
        DogV2 dogV2 = new DogV2("Шарик");
        Bird bird = new Bird("Птица");
        
        Object[] animals2 = new Object[] {catV2, catV2_2, dogV2, bird};
        for (Object animal : animals2) {
            if (animal instanceof Flyable) {
                ((Flyable)animal).fly(50);
            }
        }

    }

    public static void voiceAllAnimal (Animal[] animals) {
        for (Animal animal: animals) {
            animal.voice();
            if (animal instanceof Dog) {
                System.out.printf("Собака весит: %d\n", ((Dog)animal).getWeight());
            }
        }
    }

}

interface Runable{

    String getName();
    void swim (int distance); // можно создавать в интерфейсах методы без реализации.
    void run (int distance);

}

interface Flyable{

    void fly (int distance);

}

class CatV2 implements Runable{

    private String name;

    public CatV2 (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
    
    @Override
    public void swim(int distance) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run(int distance) {
        // TODO Auto-generated method stub
        System.out.printf("%s пробежал %d метров", name, distance);
        
    }
}

class DogV2 implements Runable{

    private String name;

    public DogV2(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void swim(int distance) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void run(int distance) {
        // TODO Auto-generated method stub
        System.out.printf("%s пробежал %d метров", name, distance);
    }

}

class Bird implements Runable, Flyable{

    private String name;
    
    public Bird(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void swim(int distance) {
        // TODO Auto-generated method stub

        
    }
    
    @Override
    public void run(int distance) {
        // TODO Auto-generated method stub
        System.out.printf("%s пробежал %d метров", name, distance);
    }

    @Override
    public void fly(int distance) {
        // TODO Auto-generated method stub
        System.out.printf("%s протетит %d метров", name, distance);
    }
}

abstract class Animal {
     
    private String name;

    public Animal (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void jump(){
        System.out.println("Животное прыгнуло");
    }

    public abstract void voice();
}

class Dog extends Animal{
    
    private int weight;

    public Dog (String name, int weight) {
        super(name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void jump() {
        System.out.println("Собака прыгает.");
    }

    @Override
    public void voice(){
        System.out.println("Собака лает.");
    }

}

class Cat extends Animal{
    
    private String color;

    public Cat (String name, String color) {
        super(name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает.");
    }

    @Override
    public void voice(){
        System.out.println("Кот мяукает.");
    }
    
}