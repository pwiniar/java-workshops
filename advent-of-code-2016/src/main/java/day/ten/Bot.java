package day.ten;

import lombok.Data;

/**
 * Created by Pawel on 2016-12-11.
 */
@Data
public class Bot {

    private int botNumber;
    private Bot low;
    private Bot high;
    private int value;

    public Bot(int botNumber) {
        this.botNumber = botNumber;
    }
}
