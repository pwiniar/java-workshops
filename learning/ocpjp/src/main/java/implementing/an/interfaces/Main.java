package implementing.an.interfaces;


/**
 * Created by Winiar on 05.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        BeachBall beachBall = new BeachBall();
        beachBall.bounceBeach();
        beachBall.rollBall();

        beachBall.jump().touch();


    }

}
