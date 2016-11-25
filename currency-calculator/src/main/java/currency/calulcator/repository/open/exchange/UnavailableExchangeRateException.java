package currency.calulcator.repository.open.exchange;

/**
 * Created by Pawel on 2016-11-25.
 */

public class UnavailableExchangeRateException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnavailableExchangeRateException(String message) {
        super(message);
    }
}
