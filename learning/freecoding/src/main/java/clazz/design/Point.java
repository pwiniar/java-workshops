package clazz.design;

/**
 * Created by pawelwiniarski on 14/10/2017.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public String toString(Object o) {
        return o.toString();
    }
}
