package geekbrains.main;

/**
 * Продукт
 */
public class Product {

    protected String name;
    protected String brand;
    protected double price;

    String param1;
    boolean param2;
    String param3;
    
    /**
     * Инициализатор работает в первую очередь. 
     * Вызываются\создаются поля в инициализаторе, и только потом вызывается конструктор
     */
    {
        System.out.println("Initializer");
        param1 = "....";
        param2 = true;
        param3 = "===";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            this.name = "NoName";
        } else {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        throw new RuntimeException("Цена указана не корректно");
        // if (price <= 0) {
        //     this.price = 1;
        // } else {
        //     this.price = price;
        // }
    }
    

    /**
     * Конструкторы
     */
    public Product(){
        this("Продукт");
    }

    public Product(String name){
        this(name, 1);
    }

    public Product(String name, double price){
        this("Noname", name, price);
    }

    public Product(String brand, String name, double price){
        if (brand.length() < 3) {
            this.brand = "NoName";
        } else {
            this.brand = brand;
        }

        if (name.length() < 3) {
            this.name = "NoName";
        } else {
            this.name = name;
        }

        if (price <= 0) {
            this.price = 1;
        } else {
            this.price = price;
        }
    }

    /**
     * Получить информацию по продукту
     * @return Информация по продукту
     */
    String displayInfo(){
        return String.format("%s - %s - %,.2f", brand, name, price);
    }
    
}