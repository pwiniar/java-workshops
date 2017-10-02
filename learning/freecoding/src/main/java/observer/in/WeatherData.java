package observer.in;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Winiar on 21.09.2017.
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementChanged() {
        super.setChanged();
        super.notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public void removeObserver(Observer o) {
        super.deleteObserver(o);
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
