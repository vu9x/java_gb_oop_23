package seminars.s5_2.presenters;
import java.util.Collection;
import java.util.Date;

import seminars.s5_2.models.Table;

public interface Model {

    /**
     * Все столики в ресторане
     * @return
     */
    public Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    public String reservationTable(Date reservationDate, int tableNo, String name);
    public String changeReservationTable(int oldReservationID, Date reservationDate, String name);
}
