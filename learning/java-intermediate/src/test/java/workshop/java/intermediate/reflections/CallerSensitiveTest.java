package workshop.java.intermediate.reflections;

import org.junit.Test;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * Created by michal on 21.10.2016.
 */
public class CallerSensitiveTest {

    @Test
    public void willItWork() throws Exception {

    }

    @CallerSensitive
    public void method() throws Exception {
        Class<?> callerClass = Reflection.getCallerClass();

    }
}
