package event.driven.architecture.handler;

import event.driven.architecture.event.UserCreatedEvent;
import event.driven.architecture.framework.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCreatedEventHandler.class);


    @Override
    public void onEvent(UserCreatedEvent event) {
        LOGGER.info("User '{}' has been Created!", event.getUser().getUsername());
    }
}
