package seminars.s5_2.models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private final int tableNumber;
    private final Collection<Reservation> reservations = new ArrayList<>();
    private static int counter;

    {
        tableNumber = ++counter;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format("Столик #%d, ", tableNumber);
    }

}
