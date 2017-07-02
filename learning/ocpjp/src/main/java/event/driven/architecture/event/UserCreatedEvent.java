package event.driven.architecture.event;

import event.driven.architecture.model.User;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserCreatedEvent extends AbstractEvent {

    private User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
