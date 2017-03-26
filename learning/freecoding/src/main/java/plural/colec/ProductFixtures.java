package plural.colec;

/**
 * Created by winiar on 15/02/2017.
 */
public class ProductFixtures {

    public static final Product door = new Product("door", 35);
    public static final Product window = new Product("window", 25);
    public static final Product floorPanel = new Product("floor", 10);


    public static final Supplayer bobs = new Supplayer("Bob's household supplies");
    public static final Supplayer kates = new Supplayer("Kats's homes goods");

    static {
        bobs.products().add(door);
        bobs.products().add(floorPanel);

        kates.products().add(floorPanel);
        kates.products().add(new Product("door", 35));
    }
}
