package activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Winiar on 03.07.2017.
 */
public class Receiver implements ExceptionListener, MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    ExecutorService executor = Executors.newSingleThreadExecutor();

    public void createReceiveTask() {
        Runnable recTask = () -> {
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_BIND_URL);
                Connection connection = connectionFactory.createConnection();
                connection.start();
                connection.setExceptionListener(this);
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("test queue");
                MessageConsumer consumer = session.createConsumer(destination);
                consumer.setMessageListener(this);
//                Message message = consumer.receive(4000);

//                consumer.close();
//                session.close();
//                connection.close();

            } catch (JMSException e) {
                LOGGER.error("Receiver createRecieveTask method error", e);
            }
        };
        executor.execute(recTask);
//        new Thread(recTask).start();
    }


    @Override
    public void onException(JMSException e) {
        LOGGER.error("Receive error occurred. {}", e.getMessage());
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = null;
            try {
                text = textMessage.getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            LOGGER.info("Received TextMessage object: {}", text);
        } else {
            LOGGER.info("Received other object type with message: {}", message);
        }
    }
}
