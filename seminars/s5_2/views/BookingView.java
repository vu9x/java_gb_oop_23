package seminars.s5_2.views;
import java.util.Collection;
import java.util.Date;

import seminars.s5_2.models.Table;
import seminars.s5_2.presenters.View;
import seminars.s5_2.presenters.ViewObserver;


public class BookingView implements View{
    
    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables){
        for (Table table : tables) {
            System.out.println(table);
        }        
    }

    /**
     * Установить наблюдателя
     * @param observer наблюдатель (презентер)
     */
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования),
     * бронирования столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Отобразить результат бронирования
     * @param reservationID номер брони
     */
    @Override
    public void showReservationStatus(String reservationInfo) {
        // TODO Auto-generated method stub
        if(!reservationInfo.isEmpty()){
            System.out.printf("Столитк успешно забронирован. %s\n", reservationInfo);
        } else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservationID идентификатор бронирования (Старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public void changeReservationTable(int oldReservationID, Date reservationDate, String name){
        observer.onUpdateReservationTable(oldReservationID, reservationDate, name);
    }
    
}
