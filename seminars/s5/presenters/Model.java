package seminars.s5.presenters;
import java.util.Collection;
import java.util.Date;

import seminars.s5.models.Table;

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
    public int reservationTable(Date reservationDate, int tableNo, String name);
}
