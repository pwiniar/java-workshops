package post.office;

import org.junit.Test;
import org.mockito.Mockito;
import post.office.provider.PolishPost;
import post.office.shipment.Shipment;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Pawel on 2017-02-26.
 */
public class ShipmentProviderTest {

    @Test
    public void numberOfShipmentIsNotLessThen50() throws Exception {

        PolishPost provider = new PolishPost("FeedEx");
        List<Shipment> shipments = provider.deliverShipment();

        assertThat(shipments.size()).isGreaterThanOrEqualTo(50);
    }

    @Test(expected = AssertionError.class)
    public void numberOfShipmentsLessThen50() throws Exception {

        PolishPost shipmentProviderMock = Mockito.mock(PolishPost.class);
        Mockito.when(shipmentProviderMock.deliverShipment()).thenReturn(Collections.emptyList());

        List<Shipment> shipments = shipmentProviderMock.deliverShipment();

        assertThat(shipments.size()).isGreaterThan(50);
    }

}
