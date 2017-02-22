package rx;

import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pawel on 2017-02-09.
 */
public class App {

    public App() {
    }

    public static void main(String[] args) {
//        hello("World", "Kasia", "Tomek");
        App app = new App();
        Observer<Calc> abs = app.obsFactory();
        division(abs);
    }

    public Observer<Calc> obsFactory() {
        return new Observer<Calc>() {
                @Override
                public void onCompleted() {
                    System.out.println("Complete");
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("We have a problem sir " + throwable.getMessage());

                }

                @Override
                public void onNext(Calc calc) {
                    System.out.println(calc.a + "/" + calc.b + "=" + calc.a / calc.b);

                }
            };
    }

    private static void hello(String... names) {
        Observable.from(names).subscribe(
                new Action1<String>() {
                    public void call(String s) {
                        System.out.println("Hello " + s);
                    }
                }
        );
    }

    private static void division(Observer<Calc> observer) {
        List<Calc> calcs = Arrays.asList(new Calc(10,2), new Calc(11,3), new Calc(100,2));
        Observable.from(calcs).subscribe(observer);
    }

    public static class Calc {
        private int a;
        private int b;

        public Calc(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Calc{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }


}
