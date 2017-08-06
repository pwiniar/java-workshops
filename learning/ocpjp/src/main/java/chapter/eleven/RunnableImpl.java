package chapter.eleven;

/**
 * Created by Winiar on 02.08.2017.
 */
public class RunnableImpl {


    public static void main(String[] args) {
        Runnable tasks = () ->
                System.out.println("In run(); thread name is: " +
                        Thread.currentThread().getName());


        Thread thread = new Thread(tasks);
        thread.setName("my runnable");
        thread.start();

        System.out.println("In main(); thread name is: " +
                Thread.currentThread().getName());

    }
}
