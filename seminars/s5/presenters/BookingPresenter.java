package seminars.s5.presenters;
import java.util.Collection;
import java.util.Date;

import seminars.s5.models.Table;

public class BookingPresenter implements ViewObserver {

    private Collection<Table> tables;

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables(){
        if (tables == null){
            this.tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView(){
        this.view.showTables(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationID номер брони
     */
    private void updateReservationStatusView(int reservationID){
        view.showReservationStatus(reservationID);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationID = model.reservationTable(orderDate, tableNo, name);
        updateReservationStatusView(reservationID);
    }

}
