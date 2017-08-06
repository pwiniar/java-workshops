package chapter.eleven;

import java.util.concurrent.TimeUnit;

/**
 * Created by Winiar on 02.08.2017.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In run(); thread name is: " + super.getName());
    }


    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.setName("my thread");
        thread.start();

        System.out.println("In main(); thread name: " +
                Thread.currentThread().getName());

    }


}
