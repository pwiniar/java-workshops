package reference.varibale.casting;

/**
 * Created by Winiar on 05.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Animal[] animals = {new Animal(), new Dog(), new Animal()};

        for (Animal a : animals) {
            a.makeNoise();
            if (a instanceof Dog) {
                Dog dog = (Dog) a;
                dog.playDead();
//                ((Dog) a).playDead();
            }
        }

        Beagle beagle = new Beagle();
        beagle.beFriendly();


    }


}
