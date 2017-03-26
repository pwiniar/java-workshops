package plural.colec;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static plural.colec.ProductFixtures.door;
import static plural.colec.ProductFixtures.floorPanel;

/**
 * Created by winiar on 17/02/2017.
 */
public class ProductCatalogeTest {

    private Product p2 = new Product("name1" , 15);

    @Test
    public void shouldOnlyHoldUniqeProducts() throws Exception {

        ProductCataloge productCataloge = new ProductCataloge();

        productCataloge.isSupplayedBy(ProductFixtures.bobs);
        productCataloge.isSupplayedBy(ProductFixtures.kates);


        Assert.assertThat(productCataloge, Matchers.containsInAnyOrder(door, floorPanel));
    }


    @Test
    public void testEq() throws Exception {
        Product p1 = new Product("name1" , 15);

        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);

        System.out.println("p1 hashcode :" + p1.hashCode());
        System.out.println("p2 hashcode :" + p2.hashCode());
        System.out.println(p1.hashCode() == p2.hashCode());


    }
}
