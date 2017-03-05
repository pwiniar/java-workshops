package post.office.shipment.management;

import post.office.shipment.Letter;
import post.office.shipment.Package;
import post.office.shipment.Shipment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Pawel on 2017-02-26.
 */
public class ShipmentManager {

    private final String name;
    //    private final Comparator<Shipment> BY_WEIGHT = (shipment1, shipment2) -> Integer.compare(shipment1.getWeight(), shipment2.getWeight());
    private final Comparator<Shipment> BY_WEIGHT = Comparator.comparingInt(Shipment::getWeight);
    private List<Letter> letters = new ArrayList<>();
    private List<Package> packages = new ArrayList<>();

    public ShipmentManager(String name) {
        this.name = name;
    }


    public void processIncomingShipment(List<Shipment> shipments) {
        shipments.forEach(s -> {
            if (s instanceof Letter) {
                letters.add(new Letter(s.getWeight(), s.getSender()));
            } else if (s instanceof Package)
                packages.add(new Package(s.getWeight(), s.getSender()));
        });
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public List<Package> getPackages() {
        return packages;
    }
}
