package lambda;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import post.office.provider.PolishPost;
import post.office.shipment.Shipment;
import post.office.shipment.management.ShipmentManager;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Pawel on 2017-03-05.
 */
public class Takietam {


    @Test
    public void name() throws Exception {
        Predicate<Trade> largeTrade = Trade::isBigTrade;

        Trade trade = new Trade();
        trade.size = 11;

        boolean test = largeTrade.test(trade);

        Assertions.assertThat(test).isEqualTo(true);

        trade.size = 2;
        boolean test1 = largeTrade.test(trade);

        Assertions.assertThat(test1).isEqualTo(true);
    }

    @Test
    public void function() throws Exception {
        Function<String, Integer> stringToInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String x) {
                return Integer.valueOf(x);
            }
        };

        String ala = "11";

        stringToInt.apply(ala);

    }

    @Test
    public void hash() throws Exception {
        String a = "AaAa";
        System.out.println(a.hashCode());

        String b = "BBBB";
        System.out.println(b.hashCode());

        String c = "AaBB";
        System.out.println(c.hashCode());

    }

    @Test
    public void name1() throws Exception {
        PolishPost shipmentProvider = new PolishPost("provider");
        List<Shipment> shipments = shipmentProvider.deliverShipment();

        ShipmentManager shipmentManager = new ShipmentManager("manager");
        shipmentManager.processIncomingShipment(shipments, PolishPost.class);

        System.out.println(shipments.getClass().getCanonicalName());

    }
}
