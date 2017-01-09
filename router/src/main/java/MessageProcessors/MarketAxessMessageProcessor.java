package MessageProcessors;

import Message.CustomMessage;
import Message.MessageType;

/**
 * Created by Pawel on 2017-01-09.
 */
public class MarketAxessMessageProcessor implements MessageProcessor {

    public void processMessage(CustomMessage message) {
        if (message.getMessageType().equals(MessageType.QuoteRequest)) {
            System.out.println("Processing Message QuoteRequest for MarektAxess");
        }
    }
}
