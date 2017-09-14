package what.is.faster.example.message.hazzelcast;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


//interface serializable  -- Serialization in java is a mechanism of writing the state of an object into a byte stream
//dlaczego long timestamp
//big deciaml


/**
 * Created by Winiar on 13.09.2017.
 */

public class StockPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    private final BigDecimal bid;
    private final BigDecimal ask;
    private final String code;
    private final String description;
    private final long timestamp;

    /**
     * Create a StockPrice for the given stock at a given moment
     */

    public StockPrice(BigDecimal bid, BigDecimal ask, String code, String description, long timestamp) {
        this.bid = bid;
        this.ask = ask;
        this.code = code;
        this.description = description;
        this.timestamp = timestamp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return new StringBuilder("Stock - ")
                .append(code)
                .append(" - ")
                .append(description)
                .append(" - Bid: ")
                .append(bid)
                .append(" - Ask: ")
                .append(ask)
                .append(" - ")
                .append(formatDate(timestamp)).toString();
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat df = new SimpleDateFormat("HH:MM:SS");
        return df.format(new Date(timestamp));
    }
}
