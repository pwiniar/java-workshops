package implementing.an.interfaces;

/**
 * Created by Winiar on 05.06.2017.
 */
public class BeachBall extends Ball {

    private boolean jumped = false;

    @Override
    public void bounceBeach() {
        System.out.println("bounce beach");
    }

    public void rollBall() {
        System.out.println("roll ball");
    }

    public BeachBall jump() {
        jumped = true;
        System.out.println("I jumped");
        return this;
    }

    public void touch() {
        System.out.println("I touched the ground");
    }
}
