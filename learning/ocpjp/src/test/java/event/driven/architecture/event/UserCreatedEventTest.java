package event.driven.architecture.event;

import event.driven.architecture.model.User;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserCreatedEventTest {

    @Test
    public void testGetEventType() {
        User user = new User("iluwatar");
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(user);
        assertEquals(UserCreatedEvent.class, userCreatedEvent.getType());
    }

}
