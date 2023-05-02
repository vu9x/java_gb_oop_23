public class Cat {
    private String name;
    private int appetite;
    private boolean isFull = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }
    public int getAppetite() {
        return appetite;
    }

    public void setFull(boolean full) {
        this.isFull = full;
    }

    public boolean getFull() {
        return isFull;
    }

    public void eat() {
//        System.out.printf("Котику %s удалось поесть\n", name);
        setFull(true);
    }
}
