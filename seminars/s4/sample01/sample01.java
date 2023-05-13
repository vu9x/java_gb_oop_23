package seminars.s4.sample01;

import java.util.Arrays;

public class sample01 {
    public static void main(String[] args) {
        // SimpleAccount simpleAccount = new SimpleAccount(5, 1000.15);
        // int simpleAccountId = simpleAccount.getId();

        // System.out.println(simpleAccount);

        // UniversalAccount universalAccount1 = new UniversalAccount("Assf1135", 1000.15);
        // UniversalAccount universalAccount2 = new UniversalAccount(5001, 1000.15);
        // UniversalAccount universalAccount3 = new UniversalAccount(new CustomAccountIdentifier(1001, "BB"), 1000.15);
        
        // System.out.println(universalAccount1);
        // System.out.println(universalAccount2);
        // System.out.println(universalAccount3);
        
        // CustomAccountIdentifier Identifier = (CustomAccountIdentifier)universalAccount3.getId();
        // Identifier.getId();

        // Account<Integer> account1 = new Account<>(1001, 1000.12);
        // System.out.println(account1);

        // int account1Id = account1.getId();
        // Account<CustomAccountIdentifier> account2 = new Account<>(new CustomAccountIdentifier(1001, "BB"), 1000.12);
        // System.out.println(account2);
        // CustomAccountIdentifier account2Id = account2.getId();
        // System.out.println(account2Id);

        Integer[] numbers = {2, 4, 6, 2, 7, 9};
        Object[] newNumbers = ArrayUtils.replaceTwoElements(numbers, 1, 2);
        String[] strs = {"AAA", "BBB", "CCC", "DDD"};
        String[]newStrs = (String[])ArrayUtils.replaceTwoElements(strs, 1, 2);

        System.out.println(Arrays.toString(newNumbers));
        System.out.println(Arrays.toString(newStrs));

        String[] aa = ArrayUtils.<String>replaceTwoElementsV2(newStrs, 2, 3);
        System.out.println(Arrays.toString(aa));

        Integer[] bb = ArrayUtils.replaceTwoElementsV2(numbers, 2, 3);
        System.out.println(bb);
    }
}

class ArrayUtils{
    public static <T> T[] replaceTwoElementsV2(T[] array,int index1, int index2){
        T[] newArray = array.clone();
        if (index1 >= array.length || index2 >= array.length || index1 < 0 || index2 <0){
            return null;
        }

        T obj = newArray[index1];
        newArray[index1] = newArray[index2];
        newArray[index2] = obj;
        return newArray;
    }

    public static Object[] replaceTwoElements(Object[] array,int index1, int index2){
        Object[] newArray = array.clone();
        if (index1 >= array.length || index2 >= array.length || index1 < 0 || index2 <0){
            return null;
        }

        Object obj = newArray[index1];
        newArray[index1] = newArray[index2];
        newArray[index2] = obj;
        return newArray;
    }

}

class Account<T>{
    private final T id;
    private double amount;

    public Account(T id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public T getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Сумма средств на счете #%s: %.2f руб.\n", id, amount);
    }

}

class UniversalAccount{
    private final Object id;
    private double amount;

    public UniversalAccount(Object id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public Object getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Сумма средств на счете #%s: %.2f руб.\n", id, amount);
    }

}

class CustomAccountIdentifier{

    private int id;
    private String prefix;

    public CustomAccountIdentifier(int id, String prefix) {
        this.id = id;
        this.prefix = prefix;
    }

    public int getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public String toString() {
        return id + prefix;
    }


}

class SimpleAccount{
    private final int id;
    private double amount;

    public SimpleAccount(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Сумма средств на счете #%s: %.2f руб.\n", id, amount);
    }


}