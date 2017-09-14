package chain.of.responsibility.two;

import chain.of.responsibility.two.handlers.ConcreteHandlerA;
import chain.of.responsibility.two.handlers.ConcreteHandlerB;
import chain.of.responsibility.two.handlers.Handler;

/**
 * Created by Winiar on 27.08.2017.
 */
public class Main {

    public static void main(String[] args) {

        Request request = new Request(Request.Type.TYPE_A);

        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        handlerA.setSuccessorHandler(handlerB);
        handlerA.handleRequest();
        handlerA.handleRequest(request);
    }

}
