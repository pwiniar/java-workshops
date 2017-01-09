import Message.CustomMessage;
import Message.MessageType;
import Message.VenueName;
import RouterFacade.RouterFacade;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pawel on 2017-01-09.
 */
public class Main extends RouterFacade {

    public static void main(String[] args) {

        List<CustomMessage> customMessages = Arrays.asList(
                new CustomMessage(VenueName.BBG, MessageType.QuoteRequest),
                new CustomMessage(VenueName.MA, MessageType.QuoteRequest),
                new CustomMessage(VenueName.TW, MessageType.ExecutionReport),
                new CustomMessage(VenueName.TW, MessageType.ExecutionReport),
                new CustomMessage(VenueName.TW, MessageType.ExecutionReport)
        );

        long millis = System.currentTimeMillis() % 1000;
        RouterFacade.interpretMessage(customMessages);
        System.out.println("Processing time: " +  ((System.currentTimeMillis() % 1000) - millis));
    }
}
