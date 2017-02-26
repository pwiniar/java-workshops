//package plural.colec;
//
//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.contains;
//
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//import static plural.colec.ProductFixtures.*;
//import static plural.colec.ProductFixtures.window;
//
///**
// * Created by winiar on 15/02/2017.
// */
//public class ShipmentTest {
//
//    private final Shipment shipment = new Shipment();
//
//    @Test
//    public void shouldAddItems() throws Exception {
//        shipment.add(door);
//        shipment.add(window);
//
//        Assert.assertThat(shipment, contains(door, window));
//    }
//
//    @Test
//    public void shouldReplaceItems() throws Exception {
//        shipment.add(door);
//        shipment.add(window);
//
//        shipment.replace(door, floorPanel);
//
//       Assert.assertThat(shipment, contains(floorPanel, window));
//    }
//
//    @Test
//    public void shouldNotReplaceMissingElement() throws Exception {
//        shipment.add(window);
//
//        shipment.replace(door, floorPanel);
//
//        Assert.assertThat(shipment, contains(window));
//    }
//
//    @Test
//    public void shouldIdentifyVanRequirements() throws Exception {
//        shipment.add(window);
//        shipment.add(door);
//        shipment.add(floorPanel);
//
//        shipment.prepare();
//
//        Assert.assertThat(shipment.getLightWeightProducts(), Matchers.contains(floorPanel));
//        Assert.assertThat(shipment.getHeavyWeightProducts(), contains(window, door));
//    }
//
//
//    @Test
//    public void ArrayListTest() throws Exception {
//        //TODO: read about linkedList and collection performance
//
//        LinkedList<Product> products = new LinkedList<>();
//
//        products.add(window);
//        products.add(door);
//        products.add(window);
//        products.add(floorPanel);
//
//        System.out.println("get(1) : " + products.get(1).getProductName());
//        System.out.println("getElement : " + products.element().getProductName());
//        System.out.println("getFirst : " + products.getFirst().getProductName());
//        System.out.println("getLast : " + products.getLast().getProductName());
//
//
//    }
//}
