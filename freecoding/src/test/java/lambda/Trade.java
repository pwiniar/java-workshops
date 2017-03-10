package lambda;

/**
 * Created by Pawel on 2017-03-05.
 */
public class Trade {

    public int size;

    public boolean isBigTrade() {
        return size > 10;
    }
}
