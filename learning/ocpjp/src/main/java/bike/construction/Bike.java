package bike.construction;


import bike.construction.components.Break;
import bike.construction.components.Frame;

/**
 * Created by Winiar on 21.06.2017.
 */
public abstract class Bike {

    private Break brake;
    private Frame frame;


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
}
