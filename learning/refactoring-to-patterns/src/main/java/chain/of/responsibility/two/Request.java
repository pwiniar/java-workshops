package chain.of.responsibility.two;

/**
 * Created by Winiar on 27.08.2017.
 */
public class Request {

    public enum Type {
        TYPE_A
    }

    private Type requestType;

    public Request(Request.Type type) {
        this.requestType = type;
    }

    public Type getRequestType() {
        return requestType;
    }
}
