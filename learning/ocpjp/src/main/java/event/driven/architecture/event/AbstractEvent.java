package event.driven.architecture.event;

import event.driven.architecture.framework.Event;

/**
 * Created by Winiar on 28.06.2017.
 */
public class AbstractEvent implements Event {

    @Override
    public Class<? extends Event> getType() {
        return getClass();
    }
}
