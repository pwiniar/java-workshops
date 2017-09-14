package what.is.faster;

/**
 * Created by Winiar on 12.09.2017.
 */
public class Main {

    public static void main(String[] args) {

        HazelcastSerwer serwer = new HazelcastSerwer();
        serwer.start();
        serwer.createMap();
        serwer.createQueue();
    }
}
