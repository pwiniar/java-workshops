package activeMq;

import java.util.concurrent.TimeUnit;

/**
 * Created by Winiar on 03.07.2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        Sender sender = new Sender();
        sender.createTask();
        TimeUnit.SECONDS.sleep(5);

        Receiver receiver = new Receiver();
        receiver.createReceiveTask();


    }

}
