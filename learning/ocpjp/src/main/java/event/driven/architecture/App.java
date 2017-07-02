package event.driven.architecture;

import event.driven.architecture.event.UserCreatedEvent;
import event.driven.architecture.event.UserDeletedEvent;
import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.framework.EventDispatcher;
import event.driven.architecture.handler.UserCreatedEventHandler;
import event.driven.architecture.handler.UserDeletedEventHandler;
import event.driven.architecture.model.User;

/**
 * Created by Winiar on 28.06.2017.
 */
public class App {

    public static void main(String[] args) {

        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerHandler(UserCreatedEvent.class, new UserCreatedEventHandler());
//        dispatcher.registerHandler(UserUpdatedEvent.class, new UserUpdatedEventHandler());
        dispatcher.registerHandler(UserDeletedEvent.class, new UserDeletedEventHandler());

        User user = new User("David");

        dispatcher.dispatch(new UserCreatedEvent(user));
        dispatcher.dispatch(new UserUpdatedEvent(user));
        dispatcher.dispatch(new UserDeletedEvent(user));

    }

}
