package ocpjp;

import org.junit.Test;

import java.util.concurrent.Executor;

/**
 * Created by Winiar on 03.08.2017.
 */

class Task implements Runnable {
    public void run() {
        System.out.println("Calling Task.run() ");
    }
}

class RepeatedExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command);
    }

    public void execute(Runnable runnable, int times) {
        System.out.printf("Calling Task.run() %d times thro' " +
                "Executor.execute() %n", times);
        for (int i = 0; i < times; i++) {
            execute(runnable);
        }
    }
}

public class ExecutorTest {


    @Test
    public void interfaceExecutor() throws Exception {
        Runnable runnable = new Task();
        System.out.println("Calling Task.run() by directly creating a Thread");
        Thread thread = new Thread(runnable);
        thread.start();
        RepeatedExecutor executor = new RepeatedExecutor();
        executor.execute(runnable, 10000);
    }

    @Test
    public void task() throws Exception {
        Runnable task = () -> System.out.println("Calling Task.run() ");

        RepeatedExecutor executor = new RepeatedExecutor();
        executor.execute(task);

    }
}
