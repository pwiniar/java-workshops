package fill.intersection;

import java.util.List;

/**
 * Created by Pawel on 2016-12-04.
 */
public class FillIntersection extends Thread {

    private Thread t;
    private List<Integer> integers;

    public FillIntersection(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            integers.add(i);
//                System.out.println(String.format("Thread: %s adding car: %s", getName(), i));
        }
    }

    public void start() {
        if (isNull()) {
            t = new Thread(this);
            t.start();
        }
    }

    public void joint() {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isNull() {
        return t == null;
    }
}
