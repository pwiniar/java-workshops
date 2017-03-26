package post.office;

import post.office.provider.PolishPost;
import post.office.shipment.Shipment;
import post.office.shipment.management.ShipmentManager;

import java.util.List;

/**
 * Created by Pawel on 2017-02-28.
 */
public class Main {

    public static void main(String[] args) {

        PolishPost provider = new PolishPost("PolishPostOffice");
        List<Shipment> shipments = provider.deliverShipment();

        ShipmentManager manager = new ShipmentManager("name");
        manager.processIncomingShipment(shipments, PolishPost.class);

        manager.getLetters().forEach(letter -> System.out.format("got letter from %s, with weight %d\n", letter.getSender(), letter.getWeight()));
        manager.getPackages().forEach(pack -> System.out.format("got pack from %s, with weight %d\n", pack.getSender(), pack.getWeight()));
    }
}
