package implementing.an.interfaces;

/**
 * Created by Winiar on 05.06.2017.
 */
public abstract class Ball implements Bouncable {
    public abstract void rollBall();

    public void bounceBeach() {
        System.out.println("bounceBeach from ball");
    }
}
