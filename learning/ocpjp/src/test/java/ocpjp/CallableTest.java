package ocpjp;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Winiar on 03.08.2017.
 */

class Factorial implements Callable<Long> {
    private long n;

    public Factorial(long n) {
        this.n = n;
    }

    @Override
    public Long call() throws Exception {
        if (n <= 0) {
            throw new Exception("for finding factorial, N should be > 0");
        }
        long fact = 1;
        for (long longVal = 1; longVal <= n; longVal++) {
            fact *= longVal;
        }
        return fact;
    }
}

public class CallableTest {

    @Test
    public void callableTest() throws Exception {
        // the value for which we want to find the factorial
        long N = 20;
        // get a callable task to be submitted to the executor service
        Callable<Long> task = new Factorial(N);
        // create an ExecutorService with a fixed thread pool having one thread
        ExecutorService es = Executors.newSingleThreadExecutor();
        // submit the task to the executor service and store the Future object
        long startTime = System.currentTimeMillis();
        Future<Long> future = es.submit(task);
        // wait for the get() method that blocks until the computation is complete.

        while (!future.isDone()) {
            System.out.printf("waiting for response \n");
        }

        long result = (System.currentTimeMillis() - startTime);
        System.out.printf("factorial of %d is %d, execution time %d ms", N, future.get(), result);
        // done. shutdown the executor service since we don't need it anymore
        es.shutdown();


    }
}
