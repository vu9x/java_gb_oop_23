package geekbrains.main;

import java.util.List;

public class BottleOfWaterVendingMachine {


    private final List<Product> products;

    /**
     * Модификатор final запрещает инициализировать переменную 
     * products во всех методах, кроме конструктора:
     */
    public BottleOfWaterVendingMachine(List<Product> products){
        this.products = products;
    }

    /**
     * Метод получения бутылки с водой
     * @param name название бутылки с водой
     * @param volume объем литров
     * @return вовзращает бутылку с водой по наименованию и объему
     */
    public BottleOfWatter getBottleOfWatter(String name, int volume){
        for (Product product : products) {
            if(product instanceof BottleOfWatter){
                if (product.getName() == name && ((BottleOfWatter)product).getVolume() == volume){
                    return (BottleOfWatter)product;
                }
            }
        }
        return null;
    }

    /**
     * Метод получения бутылки с молоком
     * @param name название бутылки с молоком
     * @param volume объем литров
     * @return вовзращает бутылку с молоком по наименованию и объему
     */
    public BottleOfMilk getBottleOfMilk(String name, int volume){
        for (Product product : products) {
            if(product instanceof BottleOfMilk){
                if (product.getName() == name && ((BottleOfMilk)product).getVolume() == volume){
                    return (BottleOfMilk)product;
                }
            }
        }
        return null;
    }

    public PlateOfChocolate getPlateOfChocolate(String name, double weight, int percentOfCacao){
        for (Product product : products) {
            if(product instanceof PlateOfChocolate){
                if(product.getName() == name && ((PlateOfChocolate)product).getWeight() == weight && ((PlateOfChocolate)product).getPercentOfCacao() == percentOfCacao){
                    return (PlateOfChocolate)product;
                }
            }
        }
        return null;
    }

}
