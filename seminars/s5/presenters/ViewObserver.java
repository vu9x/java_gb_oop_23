package seminars.s5.presenters;

import java.util.Date;

public interface ViewObserver {
    public void onReservationTable(Date orderDate, int tableNo, String name);

    
}
