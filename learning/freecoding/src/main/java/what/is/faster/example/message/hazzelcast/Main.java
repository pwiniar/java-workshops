package what.is.faster.example.message.hazzelcast;

/**
 * Created by Winiar on 14.09.2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MarketMaker bt = new MarketMaker("STOCKS", "BT.L", "British Telecom");
        MarketMaker cbry = new MarketMaker("STOCKS", "CBRY.L", "Cadburys");
        MarketMaker bp = new MarketMaker("STOCKS", "BP.L", "British Petrolium");

        bt.publishPrices();
        cbry.publishPrices();
        bp.publishPrices();
    }

}
