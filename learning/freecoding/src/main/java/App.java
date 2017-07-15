import business.FakeProductRepository;
import business.ProductRepository;

import java.io.IOException;

/**
 * Created by Winiar on 02.07.2017.
 */
public class App {

    public static void main(String[] args) throws IOException {

        ProductRepository instance = FakeProductRepository.getInstance();

        instance.findAll().forEach(System.out::println);

//        System.out.println(instance.findById(1));
//        System.out.println(instance.findByName("Yellow Bell Pepper"));
//        System.out.println(instance.findByPrice(18.75));


    }

}
