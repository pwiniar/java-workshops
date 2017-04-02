package happy;

/**
 * Created by Pawel on 2017-03-26.
 */
public class DupaFactory extends AbstractStrategyFactory {

    private static DupaFactory instance;

    public static AbstractStrategyFactory getInstance() {
        if (instance == null)
            instance = new DupaFactory();
        return instance;
    }

    public MessageStrategy createStrategy(final MessageBody mb) {
        return new MessageStrategy() {
            public void sendMessage() {
                Object payload = "dupa";
                System.err.println(payload);
            }
        };
    }
}
