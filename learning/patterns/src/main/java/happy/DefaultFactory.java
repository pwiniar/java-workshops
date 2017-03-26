package happy;

/**
 * Created by Pawel on 2017-03-26.
 */
public class DefaultFactory extends AbstractStrategyFactory {

    private DefaultFactory() {

    }

    private static DefaultFactory instance;

    public static AbstractStrategyFactory getInstance() {
        if (instance == null)
            instance = new DefaultFactory();
        return instance;
    }

    @Override
    public MessageStrategy createStrategy(final MessageBody mb) {
        return new MessageStrategy() {
            MessageBody body = mb;
            public void sendMessage() {
                Object payload = body.getPayload();
                System.err.println(payload);
            }
        };
    }
}
