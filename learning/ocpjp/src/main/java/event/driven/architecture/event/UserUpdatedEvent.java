package event.driven.architecture.event;

import event.driven.architecture.model.User;

/**
 * Created by Winiar on 28.06.2017.
 */
public class UserUpdatedEvent extends AbstractEvent {

    private final User user;

    public UserUpdatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
