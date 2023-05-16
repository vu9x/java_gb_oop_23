package seminars.s5_2;

import java.util.Date;

import seminars.s5_2.models.TableModel;
import seminars.s5_2.presenters.BookingPresenter;
import seminars.s5_2.views.BookingView;

public class Program {
    public static void main(String[] args) {
        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Ву");
        bookingView.changeReservationTable(1001, new Date(), "Ву222");
    }
}
