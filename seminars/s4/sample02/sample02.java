package seminars.s4.sample02;

public class sample02 {
    public static void main(String[] args) {
        DebitAccount<Entity> entityDebitAccount1 = 
            new DebitAccount<>(new Entity("15121316", "ООО Ромашка"), 42_000_000);

        CreditAccount<Person> personCreditAccount1 = 
            new CreditAccount<>(new Person("175125263", "Иван", "Иванов"), 20);
        

        Transaction<Account<?>> transaction1 = new Transaction<>(entityDebitAccount1, personCreditAccount1, 20_000);
        transaction1.execute();

        transaction1 = new Transaction<>(entityDebitAccount1, personCreditAccount1, 30_000);
        transaction1.execute();

    }
}

// ?  подстановочный знак, это ссылка на неизвестный тип
class Transaction<T extends Account<? extends PersonalData>>{

    private final T from;
    private final T to;
    private final double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;

    }

    public void execute(){
        if(from.getAmount() > amount){
            System.out.printf("Осуществлен перевод средств между счетами на сумму %.2f руб.\n", amount);
            System.out.printf("Счет списания #%s: %.2f руб.\nСчет зачисления : #%sЖ %.2f руб.\n", 
                from.getData(), from.getAmount(), to.getData(), to.getAmount());
            
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);

            System.out.println("Текущее состояние счета");
            System.out.println(from);
            System.out.println(to.toString());
        } else {
            System.out.println("Операция невозможна, недостаточно средств на счете.");
        }
    }

}

class DebitAccount<T extends PersonalData> extends Account<T>{
    public DebitAccount(T data, double amount){
        super(data, amount);
    }
}

class CreditAccount<T extends PersonalData> extends Account<T>{
    public CreditAccount(T data, double amount){
        super(data, amount);
    }
}

abstract class Account<T extends PersonalData>{

    private final T data;
    private double amount;

    public Account(T data, double amount) {
        this.data = data;
        this.amount = amount;
    }

    
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public T getData() {
        return data;
    }


    @Override
    public String toString() {
        return String.format("%s; %.2f руб.", data, amount);
    }

}

interface PersonalData{

    String getInn();

}

class Person implements PersonalData{

    private final String inn;
    private final String firstName;
    private final String lastName;

    
    public Person(String inn, String firstName, String lastName) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getInn() {
        // TODO Auto-generated method stub
        return inn;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s; %s %s", inn, lastName, firstName);
    }
}

class Entity implements PersonalData{
    private final String inn;
    private final String name;


    public Entity(String inn, String name) {
        this.inn = inn;
        this.name = name;
    }

    @Override
    public String getInn() {
        // TODO Auto-generated method stub
        return inn;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s; %s", inn, name);
    }
}
