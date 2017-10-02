package observer.my.display;

import observer.my.Observer;
import observer.my.Publisher;

/**
 * Created by Winiar on 21.09.2017.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Publisher weatherData;

    public CurrentConditionsDisplay(Publisher weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getSimpleName() + ".class " + "Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    public void unsubscribe() {
        weatherData.removeObserver(this);
    }
}
