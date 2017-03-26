package post.office.provider;

import post.office.shipment.Shipment;

import java.util.List;

/**
 * Created by Pawel on 2017-03-06.
 */
public interface ShipmentProvider {

    List<Shipment> deliverShipment();

}
