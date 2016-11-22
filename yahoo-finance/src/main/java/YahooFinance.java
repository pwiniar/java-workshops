import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-11-12.
 */
public class YahooFinance {

    public static List<Price> Parse(String csvData) {
        List<Price> prices = new ArrayList<>();

        String[] rows = csvData.replace("\r", "").split("\n");


        for (String row : rows) {
            if (row.isEmpty()) {
                continue;
            }
            String[] cols = row.split(",");

            Price p = new Price();
            p.symbol = cols[0];
            p.name = cols[1];
            p.bid = Double.valueOf(cols[2]);
            p.ask = Double.valueOf(cols[3]);
            p.open = Double.valueOf(cols[4]);
            p.previousclose = Double.valueOf(cols[5]);
            p.last = Double.valueOf(cols[6]);

            prices.add(p);
        }

        for (String row : rows) {
            if (row.isEmpty()) {
                continue;
            }

            String[] cols = row.split(",");

            Price p = new Price();
            p.setSymbol(cols[0]);
            p.setName(cols[1]);
            p.setBid(Double.valueOf(cols[2]));
            p.setAsk(Double.valueOf(cols[3]));
            p.setOpen(Double.valueOf(cols[4]));
            p.setPreviousclose(Double.valueOf(cols[5]));
            p.setLast(Double.valueOf(cols[6]));

            prices.add(p);
        }

        return prices;
    }


}

class Price {
    public String symbol;
    public String name;
    public Double bid;
    public Double ask;
    public Double open;
    public Double previousclose;
    public Double last;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getPreviousclose() {
        return previousclose;
    }

    public void setPreviousclose(Double previousclose) {
        this.previousclose = previousclose;
    }

    public Double getLast() {
        return last;
    }

    public void setLast(Double last) {
        this.last = last;
    }
}