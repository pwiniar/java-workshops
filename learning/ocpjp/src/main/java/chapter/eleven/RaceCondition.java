package chapter.eleven;

/**
 * Created by Winiar on 02.08.2017.
 */


class Counter {
    public static long count = 0;
}

class UseCounter implements Runnable {
    public void increment() {
        // increments the counter and prints the value
        // of the counter shared between threads
        synchronized (Counter.class) {
            Counter.count++;
            System.out.print(Counter.count + "  ");
        }
    }

    public synchronized void increment2() {
        // increments the counter and prints the value
        // of the counter shared between threads
        Counter.count++;
        System.out.print(Counter.count + "  ");
    }


    @Override
    public void run() {
        increment();
        increment();
        increment();
    }

}

public class RaceCondition {

    public static void main(String args[]) {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
    }
}
