package mocking;

/**
 * Created by Pawel on 2017-02-07.
 */
public class AuthenticatorApplication implements AuthenticatorInterface {

    private AuthenticatorInterface authenticator;

    public AuthenticatorApplication(AuthenticatorInterface authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        return this.authenticator.authenticateUser(username, password);
    }
}
