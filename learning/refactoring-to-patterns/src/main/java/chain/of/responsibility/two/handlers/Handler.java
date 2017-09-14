package chain.of.responsibility.two.handlers;

import chain.of.responsibility.two.Request;

/**
 * Created by Winiar on 27.08.2017.
 */
public abstract class Handler {

    protected Handler mSuccessorHandler;

    public abstract void handleRequest();

    public void setSuccessorHandler(Handler successorHandler) {
        mSuccessorHandler = successorHandler;
    }

    public void handleRequest(Request request) {
        switch (request.getRequestType()) {
            case TYPE_A:
                System.out.println("Handling a request of type A");
                break;
            default:
                if (mSuccessorHandler != null) {
                    mSuccessorHandler.handleRequest(request);
                }
        }
    }
}
