package Message;

/**
 * Created by Pawel on 2017-01-09.
 */
public class CustomMessage {

    private final VenueName venueName;
    private final MessageType messageType;

    public CustomMessage(VenueName venueName, MessageType messageType) {
        this.venueName = venueName;
        this.messageType = messageType;
    }

    public VenueName getVenueName() {
        return venueName;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
