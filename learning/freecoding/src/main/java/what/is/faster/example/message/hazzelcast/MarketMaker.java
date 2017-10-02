package what.is.faster.example.message.hazzelcast;

import com.google.common.annotations.VisibleForTesting;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Winiar on 14.09.2017.
 */

//volatile
//guava
//@VisibleForTesting

public class MarketMaker implements Runnable {

    private static Random random = new Random();
    private final String stockCode;
    private final String description;
    private final ITopic<StockPrice> topic;
    private volatile boolean running;
    private static HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();;

    public MarketMaker(String topicName, String stockCode, String description) {
        this.stockCode = stockCode;
        this.description = description;
        this.topic = createTopic(topicName);
        running = true;
    }

    @VisibleForTesting
    private ITopic<StockPrice> createTopic(String topicName) {
        return hzInstance.getTopic(topicName);
    }

    public void publishPrices() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        do {
            publish();
            sleep();
        } while (running);
    }

    private void publish() {
        StockPrice price = createStockPrice();
        System.out.println(price.toString());
        topic.publish(price);
    }

    @VisibleForTesting
    private StockPrice createStockPrice() {
        double price = createPrice();
        DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
        BigDecimal bid = new BigDecimal(df.format(price - variance(price)));
        BigDecimal ask = new BigDecimal(df.format(price + variance(price)));
        return new StockPrice(bid, ask, stockCode, description, System.currentTimeMillis());
    }

    private double createPrice() {
        int val = random.nextInt(2010 - 1520) + 1520;
        double retVal = (double) val / 100;
        return retVal;
    }

    private double variance(double price) {
        return (price * 0.01);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }
}
