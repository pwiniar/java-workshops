package post.office.shipment;

/**
 * Created by Pawel on 2017-02-26.
 */
public class Shipment {

    private final int weight;
    private final String sender;

    public Shipment(int weight, String sender) {
        this.weight = weight;
        this.sender = sender;
    }

    public int getWeight() {
        return weight;
    }

    public String getSender() {
        return sender;
    }
}
