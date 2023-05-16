package seminars.s5_2.presenters;
import java.util.Collection;
import seminars.s5_2.models.Table;


public interface View {
    /**
     * Отобразить список всех столиков
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables);

    public void showReservationStatus(String reservationInfo);

    /**
     * Установить нового наблюдателя
     * @param observer наблюдатель (презентер)
     */
    public void setObserver(ViewObserver observer);
}
