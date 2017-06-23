package bike.construction;


import bike.construction.components.Break;
import bike.construction.components.Frame;

/**
 * Created by Winiar on 21.06.2017.
 */
public abstract class Bike implements Bicycle {

    private Break brake;
    private Frame frame;

    private int cadecne = 0;
    private int speed = 0;
    private int gear = 1;


    public Bike addBreak(Break aBreak) {
        this.brake = aBreak;
        return this;
    }

    public Bike addFrame(Frame frame) {
        this.frame = frame;
        return this;
    }

    public Break getBrake() {
        return brake;
    }

    public Frame getFrame() {
        return frame;
    }


    @Override
    public void changeCadence(int newValue) {
        this.cadecne = newValue;
    }

    @Override
    public void changeGear(int newValue) {
        this.gear = newValue;
    }

    @Override
    public void speedUp(int increment) {
        this.speed = speed + increment;
    }

    @Override
    public void applyBrakes(int decrement) {
        this.speed = speed - decrement;
    }

    public int getCadecne() {
        return cadecne;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }
}
