package geekbrains.main;


public class PlateOfChocolate extends Product{
    private double weight;
    private int percentOfCacao;

    /**
     * Параметры шоколадки
     * @param weight вес 
     * @param percentOfCacao процент какао в шоколаде
     */
    public PlateOfChocolate(String name, int price, double weight, int percentOfCacao){
        super(name, percentOfCacao);
        this.weight = weight;
        this.percentOfCacao = percentOfCacao;
    }

    public double getWeight() {
        return weight;
    }

    public int getPercentOfCacao() {
        return percentOfCacao;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - вес: %f - процент какао:%d",super.displayInfo(), this.weight, this.percentOfCacao);
    }
}
