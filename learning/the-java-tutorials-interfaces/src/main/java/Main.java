/**
 * Created by Pawel on 2017-04-02.
 */
public class Main implements DoTheShit {

    static class Main2 implements DoTheShit {

    }

    @Override
    public int add(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Main main = Main.class.newInstance();
        Main2 main2 = new Main2();

        System.out.println(main.add(1, 2));
        System.out.println();
        System.out.println(main2.add(1, 2));
        System.out.println();
    }

}
