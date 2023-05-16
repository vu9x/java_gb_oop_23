package seminars.s5_2.models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000;
    private final int id;
    private Date date;
    private String name;
    
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    {
        id = ++ counter;
    }

    public Reservation(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Номер резерва: %d, имя: %s", this.getId(), this.getName());
    }

}
