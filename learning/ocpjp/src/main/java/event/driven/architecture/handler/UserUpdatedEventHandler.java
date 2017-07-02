package event.driven.architecture.handler;

import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.framework.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdatedEventHandler.class);

    @Override
    public void onEvent(UserUpdatedEvent event) {
        LOGGER.info("User '{}' has been Updated!", event.getUser().getUsername());
    }

}
