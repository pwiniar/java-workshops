package java8;

/**
 * Created by Winiar on 22.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));

    }
}
