package happy;

/**
 * Created by Pawel on 2017-03-26.
 */
public abstract class AbstractStrategyFactory {

    public abstract MessageStrategy createStrategy(MessageBody mb);

    public static class MessageBody {
        Object payload;

        public Object getPayload() {
            return payload;
        }

        public void configure(Object obj) {
            payload = obj;
        }

        public void send(MessageStrategy ms) {
            ms.sendMessage();
        }
    }

}
