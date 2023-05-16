package seminars.s5_2.presenters;

import java.util.Date;

public interface ViewObserver {
    public void onReservationTable(Date orderDate, int tableNo, String name);
    public void onUpdateReservationTable(int oldReservationID, Date reservationDate, String name);  
}
