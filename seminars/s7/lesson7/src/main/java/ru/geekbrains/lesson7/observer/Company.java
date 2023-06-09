package ru.geekbrains.lesson7.observer;

import java.util.Random;

public class Company implements Vacancy{

    private Random random;
    private String nameCompany;
    private double maxSalary;

    private Publisher jobAgency;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = 3000 + (maxSalary - 3000) * random.nextDouble();
        this.jobAgency = jobAgency;
        random = new Random();
    }

    /**
     * TODO: Доработать метод, компания должна генерировать объект "Вакансия" и передавать
     *  объект в агенство.
     * Поиск сотрудника
     */
    @Override
    public void newVacancy(){
        jobAgency.sendOffer(nameCompany, maxSalary);
    }

    // public void needEmployee(){
    //     double salary = 3000 + (maxSalary - 3000) * random.nextDouble();
    //     jobAgency.sendOffer(nameCompany, salary);
    // }

}
