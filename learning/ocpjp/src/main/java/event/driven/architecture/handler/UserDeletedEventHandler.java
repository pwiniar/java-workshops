package event.driven.architecture.handler;

import event.driven.architecture.event.UserDeletedEvent;
import event.driven.architecture.framework.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserDeletedEventHandler implements Handler<UserDeletedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeletedEventHandler.class);

    @Override
    public void onEvent(UserDeletedEvent event) {
        LOGGER.info("User '{}' has been Deleted!", event.getUser().getUsername());
    }
}
