package post.office.provider;

import post.office.shipment.Letter;
import post.office.shipment.Package;
import post.office.shipment.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pawel on 2017-02-26.
 */
public class ShipmentProvider {

    private final String name;
    private final Random random = new Random();
    private static int MAX_NUMBER_OF_SHIPMENTS = 500;
    private static int MIN_NUMBER_OF_SHIPMENTS = 50;

    public ShipmentProvider(String name) {
        this.name = name;
    }

    public List<Shipment> deliverShipment() {
        List<Shipment> shipments = new ArrayList<>();

        for (int i = 0; i < random.nextInt((MAX_NUMBER_OF_SHIPMENTS - MIN_NUMBER_OF_SHIPMENTS) + 1) + MIN_NUMBER_OF_SHIPMENTS; i++) {
            int randomWeight = random.nextInt((30 - 1) + 1) + 1;

            shipments.add((randomWeight > 15) ? new Package(randomWeight, "Piekna " + i) : new Letter(randomWeight, "Pużaka " + i));
        }

        return shipments;
    }
}
