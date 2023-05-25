package ru.geekbrains.lesson7.observer;

public class JuniorJavaDev implements Observer{

    private  String name;
    private double salary;

    public JuniorJavaDev(String name) {
        this.name = name;
        salary = 40_000;
    }

    @Override
    public void receiveOffer(String companyName, double salary) {
        if (this.salary < salary){
            System.out.printf("Джуниор Java Разработчик %s >>> Мне нужна эта работа! [%s - %f]\n", name, companyName, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("Джуниор Java Разработчик %s >>> Я найду работу получше! [%s - %f]\n", name, companyName, salary);
        }
    }
    
}
