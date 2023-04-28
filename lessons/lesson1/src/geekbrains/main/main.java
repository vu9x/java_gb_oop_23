package geekbrains.main;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Product product1 = new Product();
        // Product product2 = new Product("Бутылка с молоком");
        // Product product3 = new Product("Бутылка с молоком", 200);
        // Product product4 = new Product("ООО Источник", "Бутылка с молоком", 200);

        // System.out.println(product1.displayInfo());
        // System.out.println(product2.displayInfo());
        // System.out.println(product3.displayInfo());
        // System.out.println(product4.displayInfo());

        BottleOfWatter bottleofwater1 = new BottleOfWatter("Вода", 100, 1);
        System.out.println(bottleofwater1.displayInfo());

        Product bottleOfWatter2 = new BottleOfWatter("Вода", 100, 2);
        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 100, 2, 10);

        Product bottleOfWatter3 = new BottleOfWatter("Вода2", 100, 1);
        Product bottleOfWatter4 = new BottleOfWatter("Вода3", 110, 3);
        Product bottleOfWatter5 = new BottleOfWatter("Вода4", 130, 1);

        Product plateOfChocolate1 = new PlateOfChocolate("Аленка", 50, 0.5, 30);
        Product plateOfChocolate2 = new PlateOfChocolate("Ritter Sport", 100, 0.5, 50);
        Product plateOfChocolate3 = new PlateOfChocolate("Lindt", 150, 0.5, 80);
        Product plateOfChocolate4 = new PlateOfChocolate("Dove", 80, 0.5, 40);

        List<Product> products = new ArrayList<Product>();
        products.add(bottleOfWatter2);
        products.add(bottleOfMilk1);
        products.add(bottleOfWatter3);
        products.add(bottleOfWatter4);
        products.add(bottleOfWatter5);
        products.add(plateOfChocolate1);
        products.add(plateOfChocolate2);
        products.add(plateOfChocolate3);
        products.add(plateOfChocolate4);

        BottleOfWaterVendingMachine machine = new BottleOfWaterVendingMachine(products);
        BottleOfWatter bottleOfWatterRes = machine.getBottleOfWatter("Вода", 2);
        if(bottleOfWatterRes != null){
            System.out.println("Вы купили: ");
            System.out.println(bottleOfWatterRes.displayInfo());
        } else {
            System.out.println("Такой бутылки с водой нет в автомате");
        }

        PlateOfChocolate plateOfChocolateRes = machine.getPlateOfChocolate("Ritter Sport", 0.5, 50);
        System.out.println(plateOfChocolateRes.displayInfo());

    }
}