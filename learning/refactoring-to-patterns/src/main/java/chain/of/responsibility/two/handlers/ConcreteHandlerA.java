package chain.of.responsibility.two.handlers;

/**
 * Created by Winiar on 27.08.2017.
 */
public class ConcreteHandlerA extends chain.of.responsibility.two.handlers.Handler {

    @Override
    public void handleRequest() {
        System.out.println("Passing request to ConcreteHandlerA's successor.");
        mSuccessorHandler.handleRequest();
    }
}
