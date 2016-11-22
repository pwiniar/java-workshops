package beginner.basics.beginner.designpatterns;

import org.testng.annotations.Test;

/**
 * Created by michal on 15.06.2016.
 */
public class SingletonTest {

    @Test
    public void testSingleton() throws Exception {

        Singleton.INSTANCE.toString();


        Singleton.INSTANCE.toString();

    }
}
