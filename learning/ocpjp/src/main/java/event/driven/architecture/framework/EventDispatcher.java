package event.driven.architecture.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Winiar on 28.06.2017.
 */
public class EventDispatcher {

    private Map<Class<? extends Event>, Handler<? extends Event>> handlers;


    public EventDispatcher() {
        handlers = new HashMap<>();
    }

    public <E extends Event> void registerHandler(Class<E> eventType, Handler<E> handler) {
        handlers.put(eventType, handler);
    }

    @SuppressWarnings("unchecked")
    public <E extends Event> void dispatch(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());
        if (handler != null) {
            handler.onEvent(event);
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends Event> void processEvent(E event) {
        Handler<E> handler = (Handler<E>) handlers.get(event.getClass());

        if (handler != null) {
            handler.onEvent(event);
        }
    }


}
