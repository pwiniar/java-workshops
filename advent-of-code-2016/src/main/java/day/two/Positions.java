package day.two;

/**
 * Created by Pawel on 2016-12-16.
 */
public enum Positions {
    one(0, 0), two(0, 1), tree(0, 2),
    four(1, 0), five(1, 2), six(1, 2),
    seven(2, 0), eigght(2, 1), nine(2, 2);

    private final int x;
    private final int y;

    Positions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
