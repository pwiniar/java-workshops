package post.office;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import post.office.provider.PolishPost;
import post.office.shipment.Shipment;
import post.office.shipment.management.ShipmentManager;

import java.util.List;


/**
 * Created by Pawel on 2017-02-26.
 */
public class ShipmentManagerTest {

    @Test
    public void shipmentsAreCorrectlySorted() throws Exception {
        PolishPost shipmentProvider = new PolishPost("provider");
        List<Shipment> shipments = shipmentProvider.deliverShipment();

        ShipmentManager shipmentManager = new ShipmentManager("manager");
        shipmentManager.registerProvider(shipmentProvider);
        shipmentManager.processIncomingShipment(shipments, PolishPost.class);

        Assertions.assertThat(shipmentManager.getLetters().get(0).getWeight()).isLessThan(15);
        Assertions.assertThat(shipmentManager.getPackages().get(0).getWeight()).isGreaterThan(15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void providerNotDefined() throws Exception {
        PolishPost shipmentProvider = new PolishPost("provider");
        List<Shipment> shipments = shipmentProvider.deliverShipment();

        ShipmentManager shipmentManager = new ShipmentManager("manager");
        shipmentManager.processIncomingShipment(shipments, PolishPost.class);

        Assertions.assertThat(shipmentManager.getLetters().get(0).getWeight()).isLessThan(15);
        Assertions.assertThat(shipmentManager.getPackages().get(0).getWeight()).isGreaterThan(15);

    }
}
