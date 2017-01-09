package MessageProcessors;

import Message.CustomMessage;

/**
 * Created by Pawel on 2017-01-09.
 */
public interface MessageProcessor {

    void processMessage(CustomMessage message);
}
