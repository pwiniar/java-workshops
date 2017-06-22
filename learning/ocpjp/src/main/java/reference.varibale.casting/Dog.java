package reference.varibale.casting;

/**
 * Created by Winiar on 05.06.2017.
 */
public class Dog extends Animal implements Pet {

    @Override
    public void makeNoise() {
        System.out.println("bark");
    }

    public void playDead() {
        System.out.println("roll over");
    }

    public void beFriendly() {
        System.out.println("waving with tail");
    }
}
