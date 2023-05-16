package seminars.s5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import seminars.s5.presenters.Model;

public class TableModel implements Model {

    private Collection<Table> tables;

    public Collection<Table> loadTables(){
        if(tables == null) {
            this.tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name){
        for(Table table: tables){
            if(table.getTableNumber() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        // throw new RuntimeException("Некорректный номер столика");
    }


    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservationID идентификатор бронирования (Старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    public int changeReservationTable(int oldReservationID, Date reservationDate, int tableNo, String name){
        return -1;
    }


}
