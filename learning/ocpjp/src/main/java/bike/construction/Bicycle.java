package bike.construction;

/**
 * Created by Winiar on 22.06.2017.
 */
public interface Bicycle {

    void changeCadence(int newValue);
    void changeGear(int newValue);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}
