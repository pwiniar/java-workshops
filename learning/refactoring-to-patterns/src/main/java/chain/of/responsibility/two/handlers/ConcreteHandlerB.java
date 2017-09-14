package chain.of.responsibility.two.handlers;

/**
 * Created by Winiar on 27.08.2017.
 */
public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest() {
        System.out.println("ConcreteHandlerB handling request.");
    }
}
