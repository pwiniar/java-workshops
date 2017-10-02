package what.is.faster.example.message.hazzelcast;

import com.hazelcast.core.*;

/**
 * Created by Winiar on 20.09.2017.
 */
public class Client implements MessageListener<StockPrice> {

    public Client(String topicName) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        ITopic<StockPrice> topic = hazelcastInstance.getTopic(topicName);
        topic.addMessageListener(this);
    }

    @Override
    public void onMessage(Message<StockPrice> arg0) {
        System.out.println("Received: " + arg0.getMessageObject().toString());
    }

    public static void main(String[] args) {
        new Client("STOCKS");
    }
}
