package observer.my;

import java.util.ArrayList;

/**
 * Created by Winiar on 21.09.2017.
 */
public class WeatherData implements Publisher {
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
//        int i = observers.indexOf(o);
//        if (i >= 0) {
//            observers.remove(i);
//        }
        observers.remove(o);
    }


    @Override
    public void notifyObservers() {
        observers.forEach(observer ->
                observer.update(temperature, humidity, pressure));
    }

    public void measurementChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

}
