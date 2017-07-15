package activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winiar on 03.07.2017.
 */
public class Sender {

    private final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private SecureRandom random = new SecureRandom();
    private int numberOfMessageStreames;
    private List<TextMessage> streamed = new ArrayList<>();

    public void createTask() {
        String taskName = generateTaskName();
        Runnable sendTask = () -> {
            ActiveMQConnectionFactory connectionFactory = new
                    ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
            try {
                Connection connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("test queue");
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                for (int i = 0; i < 20; i++) {
                    String text = "Hello from: " + taskName + " : " + this.hashCode() + " " + i;
                    TextMessage textMessage = session.createTextMessage(text);

//                    LOGGER.info("Sent message hash code: {} : {}", textMessage.hashCode(), taskName);

                    streamed.add(textMessage);
                    producer.send(textMessage);
                    numberOfMessageStreames = i + 1;
                    LOGGER.info("Message: {} : {}", i, textMessage.getText());
                }
                LOGGER.info("Number of messages sent: {}", numberOfMessageStreames);

//                session.close();
//                connection.close();
            } catch (JMSException e) {
                LOGGER.error("Sender create task error: {}", e.getMessage());
            }
        };

        new Thread(sendTask).start();
    }


    private String generateTaskName() {
        return new BigInteger(20, random).toString(16);
    }

    public List<TextMessage> getStreamed() {
        return streamed;
    }
}
