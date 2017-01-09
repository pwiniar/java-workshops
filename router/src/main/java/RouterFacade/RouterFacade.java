package RouterFacade;

import Message.CustomMessage;
import Message.VenueName;
import MessageProcessors.BloombergMessageProcessor;
import MessageProcessors.MarketAxessMessageProcessor;
import MessageProcessors.MessageProcessor;
import MessageProcessors.TradewebMessageProcessor;

import java.util.List;

/**
 * Created by Pawel on 2017-01-09.
 */
public class RouterFacade {

    private static final MessageProcessor bbg = new BloombergMessageProcessor();
    private static final MessageProcessor tw = new TradewebMessageProcessor();
    private static final MessageProcessor ma = new MarketAxessMessageProcessor();

    public static void interpretMessage(List<CustomMessage> customMessage) {
        for (CustomMessage msg : customMessage) {
            if (msg.getVenueName().equals(VenueName.BBG)) {
                bbg.processMessage(msg);
            } else if (msg.getVenueName().equals(VenueName.TW)) {
                tw.processMessage(msg);
            } else if (msg.getVenueName().equals(VenueName.MA)) {
                ma.processMessage(msg);
            }
        }
    }


}
