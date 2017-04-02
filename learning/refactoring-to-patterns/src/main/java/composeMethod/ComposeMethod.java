package composeMethod;

import java.math.BigDecimal;

/**
 * Created by Pawel on 2017-03-28.
 */
public class ComposeMethod {

    private boolean readOnly = false;
    private int size = 0;
    private Object[] elements = new Object[0];
    private static final int GROWTH_INCREMENT = 10;
    public int iterator = 0;
    public int iterator2 = 0;

    public void add(Object element) {
        if (!readOnly) { //wychodzimy z methody nie wiadomo dlaczego
            int newSize = size + 1;
            if (newSize > elements.length) {
                this.iterator++;
                Object[] newElements = new Object[elements.length + 10];
                for (int i = 0; i < size; i++)
                    newElements[i] = elements[i];
                elements = newElements;
            }
            elements[size++] = element;
        }
    }

    public void addRefactored(Object element) {
        if (readOnly) //wychodzimy z methody nie wiadomo dlaczego
            return;
        if (atCapacityChange())
            grow();

        elements[size++] = element;
    }

    public void grow() {
        this.iterator2++;
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private boolean atCapacityChange() {
        return (size + 1) > elements.length;
    }

    public static void main(String[] args) {
        ComposeMethod cm = new ComposeMethod();

        double start = System.nanoTime();
        for (int i = 0; i < 90000; i++) {
            cm.add("ok" + i);
        }
        double stop = (System.nanoTime() - start) / 1000000000;
        BigDecimal finalValue = new BigDecimal(stop);
        System.err.println("OLD IMPLEMENTATION TIME: " + finalValue.setScale(4, BigDecimal.ROUND_HALF_UP) + "s TIMES GROW : " + cm.iterator);

        double startn = System.nanoTime();
        for (int i = 0; i < 90000; i++) {
            cm.addRefactored("ok" + i);
        }
        double stopn = (System.nanoTime() - startn) / 1000000000;
        BigDecimal finalValuen = new BigDecimal(stopn);
        System.err.println("NEW IMPLEMENTATION TIME: " + finalValuen.setScale(4, BigDecimal.ROUND_HALF_UP) + "s TIMES GROW : " + cm.iterator2);
    }
}
