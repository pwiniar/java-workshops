import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Winiar on 12.07.2017.
 */
public class Tests {


    @Test
    public void name() throws Exception {
        FileInputStream crunchifyStream1 = null;
        final FileInputStream crunchifyStream2 = null;
        String fileName = "Crunchify.txt";
        CrunchifyThrowThrows.crunchifyTest1(fileName);
        System.out.println("main: Starting " + CrunchifyThrowThrows.class.getName() + " with file name = " + fileName);


    }
}

class CrunchifyThrowThrows {

    public static FileInputStream crunchifyTest1(String fileName) throws FileNotFoundException {
        FileInputStream crunchifyStream = new FileInputStream(fileName);
        while (true) {
            System.out.println("crunchifyTest1: File input stream created");
            return crunchifyStream;
        }

    }

    public static FileInputStream crunchifyTest2(String fileName) {
        FileInputStream crunchifyStream = null;
        try {
            crunchifyStream = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Runtime exception");
            //System.out.println("crunchifyTest2: Oops, FileNotFoundException caught");
        } finally {
            System.out.println("crunchifyTest2: finally block");
        }
        System.out.println("crunchifyTest2: Returning from crunchifyTest2");
        return crunchifyStream;
    }

}
