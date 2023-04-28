package geekbrains.main;

public class BottleOfWatter extends Product {
    
    private int volume;

    public BottleOfWatter(String name, double price, int volume){
        super(name, price);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    String displayInfo(){
        // return super.displayInfo();
        return String.format("%s - %s - %f - объем: %d", brand, name, price, volume);
    }

}
