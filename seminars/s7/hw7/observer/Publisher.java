package seminars.s7.hw7.observer;

public interface Publisher{

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void sendOffer(String nameCompany, double salary);

}
