package java8;

/**
 * Created by Winiar on 22.06.2017.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
