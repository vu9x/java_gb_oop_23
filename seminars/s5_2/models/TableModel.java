package seminars.s5_2.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import seminars.s5_2.presenters.Model;

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

    public String reservationTable(Date reservationDate, int tableID, String name){
        for(Table table: tables){
            if(table.getTableNumber() == tableID){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return table.toString() + reservation.toString();
            }
        }
        return null;
        // throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservationID идентификатор бронирования (Старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     * public int changeReservationTable(int oldReservationID, Date reservationDate, int tableNo, String name){
     */
    public String changeReservationTable(int oldReservationID, Date reservationDate, String name){
        for(Table table: tables){
            for (Reservation reservation : table.getReservations()) {
                if(reservation.getId() == oldReservationID){
                    reservation.setDate(reservationDate);
                    reservation.setName(name);
                    return table.toString() + reservation.toString();
                }
            }
        }
        return null;
    }


}
