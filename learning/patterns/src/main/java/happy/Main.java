package happy;

/**
 * Created by Pawel on 2017-03-26.
 */
public class Main {

    public static void main(String[] args) {
        AbstractStrategyFactory.MessageBody mb = new AbstractStrategyFactory.MessageBody();
        mb.configure("Hello World!");

        AbstractStrategyFactory asf = DupaFactory.getInstance();
        MessageStrategy strategy = asf.createStrategy(mb);
        mb.send(strategy);
    }
}
