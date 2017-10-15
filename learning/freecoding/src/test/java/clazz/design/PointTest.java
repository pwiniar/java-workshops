package clazz.design;

import org.junit.Test;
import org.omg.CORBA.Object;

/**
 * Created by pawelwiniarski on 14/10/2017.
 */
public class PointTest {

    @Test
    public void printObject() throws Exception {

        Point point = new Point(10,2);

        System.out.println(point.toString(point));

//        System.out.println(point);
    }

    @Test
    public void obj() throws Exception {
        java.lang.Object object = new Point(11,2);
        System.out.println(object);

    }
}
