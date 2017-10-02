package in;

/**
 * Created by Winiar on 21.09.2017.
 */
public interface Publisher {

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();


}
