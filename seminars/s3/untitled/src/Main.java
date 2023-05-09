import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static Random random = new Random();

    static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int salary = random.nextInt(100, 200);
        int index = random.nextInt(176,250);
        int age = random.nextInt(18, 60);


        if (random.nextInt(2) == 1) {
            return new Worker(names[random.nextInt(10)], surNames[random.nextInt(10)], salary * index, age);
        } else{
            return new Freelancer(names[random.nextInt(10)], surNames[random.nextInt(10)],salary, age);
        }

//        Employee[] employee = new Employee[]{new Worker(names[random.nextInt(10)], surNames[random.nextInt(10)],salary * index), new Freelancer(names[random.nextInt(10)], surNames[random.nextInt(10)],salary)};
//        return employee[random.nextInt(1)];
    }

    public static void main(String[] args) {
//        Worker worker = new Worker("Анатолий", "Иванов", 80000);
//        Freelancer freelancer = new Freelancer("Анатолий", "Иванов", 300);
//        System.out.println(worker.toString());
//        System.out.println(freelancer.toString());

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        System.out.printf("\n*** Первоначальынй массив сотрудников ***\n");
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.printf("\n*** Отсортированный массив сотрудников по возрасту***\n");
        Arrays.sort(employees, new AgeComparator());
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.printf("\n*** Отсортированный массив сотрудников по имени***\n");
        Arrays.sort(employees, new NameComparator());
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.printf("\n*** Отсортированный массив сотрудников по Зарплате***\n");
        Arrays.sort(employees);
        for (Employee employee: employees) {
            System.out.println(employee);
        }

//
////        Arrays.sort(employees, new SalaryComparator());
//        System.out.printf("\n*** Отсортированный массив сотрудников ***");
//
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }
    }
}

class SalaryComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        // return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1: -1);
        return Double.compare(o1.calculateSalary(), o2.calculateSalary());
    }
}

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        // return o1.calculateSalary() == o2.calculateSalary() ? 0 : (o1.calculateSalary() > o2.calculateSalary() ? 1: -1);
        return o1.name.compareTo(o2.name);
    }
}

class AgeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getAge() == o2.getAge()){return 0;
        } else if (o1.getAge() > o2.getAge()) {return 1;
        } else {return -1;}
    }
}

abstract class Employee implements Comparable<Employee>{
    protected String name;
    protected String surName;
    protected double salary;
    protected int age;

    public Employee(String name, String surName, double salary, int age){
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Средняя заработная плата: %.2f", name, surName, salary);

    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee{
    public Worker(String name, String surName, double salary, int age){
        super(name, surName, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d; Рабочий; Средняя заработная плата (фиксированная месячная оплата): %.2f (руб.)", name, surName, age, salary);
    }
}

class Freelancer extends Employee{

    private double hourlyPayment;

    public Freelancer(String name, String surName, double hourlyPayment, int age) {
        super(name, surName, (hourlyPayment * 4 * 22), age);
        this.hourlyPayment = hourlyPayment;
    }
    @Override
    public double calculateSalary() {
        return super.salary;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d; Фрилансер; Ставка в час: %.2f; Получил за месяц: %.2f (руб.)", name, surName, age, hourlyPayment, super.salary);
    }
}
