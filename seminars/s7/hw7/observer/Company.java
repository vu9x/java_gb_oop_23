package seminars.s7.hw7.observer;

import java.util.Random;

public class Company implements Vacancy{

    private Random random;
    private String nameCompany;
    private double maxSalary;

    private Publisher jobAgency;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        random = new Random();
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
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
