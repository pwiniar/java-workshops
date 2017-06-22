package bike.construction.components;

/**
 * Created by Winiar on 21.06.2017.
 */
public class Break {

    private final BreakType breakType;

    public enum BreakType {
        DISCK_BRAKES, VBREAK
    }

    public Break(BreakType breakType) {
        this.breakType = breakType;
    }

    @Override
    public String toString() {
        return "Break{" +
                "breakType=" + breakType +
                '}';
    }
}
