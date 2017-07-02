package event.driven.architecture.framework;

/**
 * Created by Winiar on 28.06.2017.
 */
public interface Handler<E extends Event> {

    void onEvent(E event);
}
