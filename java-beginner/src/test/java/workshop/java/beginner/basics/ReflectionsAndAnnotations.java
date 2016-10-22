package workshop.java.beginner.basics;

import org.testng.annotations.Test;

import javax.jws.WebService;
import java.lang.reflect.Field;

/**
 * Created by michal on 15.06.2016.
 */
public class ReflectionsAndAnnotations {

    @Test(enabled = false)
    public void testName() throws NoSuchFieldException, IllegalAccessException {
        AnnotatedWithSomething service = new AnnotatedWithSomething("instance one");
        System.out.println(service.getServiceField());

        service.getClass();// gives same class as AnnotatedWithSomething.class;

        Class<? extends AnnotatedWithSomething> aClass = AnnotatedWithSomething.class;
        WebService annotation = aClass.getAnnotation(WebService.class);

        Field serviceField = aClass.getField("serviceField");
        serviceField.setAccessible(true);

        System.out.println(aClass.getSimpleName()
                + "." + serviceField.getName()
                + " = " + serviceField.get(service));

    }

    @WebService(name = "firstWebService")
    public static class AnnotatedWithSomething {

        private String serviceField = "init value";

        public AnnotatedWithSomething(String value) {
            this.serviceField = value;
        }

        public String getServiceField() {
            return serviceField;
        }
    }
}
