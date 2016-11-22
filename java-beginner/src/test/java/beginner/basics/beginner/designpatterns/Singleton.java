package beginner.basics.beginner.designpatterns;

/**
 * Created by michal on 15.06.2016.
 */
public class Singleton {

    public final static Singleton INSTANCE = new Singleton();

    private Singleton() {
    }
}
