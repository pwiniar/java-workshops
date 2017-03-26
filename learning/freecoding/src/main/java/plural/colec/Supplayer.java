package plural.colec;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winiar on 17/02/2017.
 */
public class Supplayer {

    private final String name;
    private List<Product> products = new ArrayList<>();


    public Supplayer(String s) {
        this.name = s;
    }

    public List<Product> products(){
        return this.products;
    }
}
