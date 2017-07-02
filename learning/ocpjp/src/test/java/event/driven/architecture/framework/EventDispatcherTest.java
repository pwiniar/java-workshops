package event.driven.architecture.framework;

import event.driven.architecture.event.UserCreatedEvent;
import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.handler.UserCreatedEventHandler;
import event.driven.architecture.handler.UserUpdatedEventHandler;
import event.driven.architecture.model.User;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * Created by Winiar on 28.06.2017.
 */
public class EventDispatcherTest {

    @Test
    public void testEventDriverPattern() {

        EventDispatcher dispatcher = spy(new EventDispatcher());
        UserCreatedEventHandler userCreatedEventHandler = spy(new UserCreatedEventHandler());
        UserUpdatedEventHandler userUpdatedEventHandler = spy(new UserUpdatedEventHandler());
        dispatcher.registerHandler(UserCreatedEvent.class, userCreatedEventHandler);
        dispatcher.registerHandler(UserUpdatedEvent.class, userUpdatedEventHandler);

        User user = new User("iluwatar");

        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent(user);

        //fire a userCreatedEvent and verify that userCreatedEventHandler has been invoked.
        dispatcher.dispatch(userCreatedEvent);
        verify(userCreatedEventHandler).onEvent(userCreatedEvent);
        verify(dispatcher).dispatch(userCreatedEvent);

        //fire a userCreatedEvent and verify that userUpdatedEventHandler has been invoked.
        dispatcher.dispatch(userUpdatedEvent);
        verify(userUpdatedEventHandler).onEvent(userUpdatedEvent);
        verify(dispatcher).dispatch(userUpdatedEvent);
    }
}
