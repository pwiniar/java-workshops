package mocking;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

/**
 * Created by Pawel on 2017-02-07.
 */
//@RunWith(MockitoJUnitRunner.class)
//public class AuthenticatorApplicationTest {
//    @Mock
//    private AuthenticatorInterface authenticatorMock;
//
//    @InjectMocks
//    private AuthenticatorApplication authenticator ;
//
//    @Test
//    public void authenticationTest() throws Exception {
//
//        String username = "JavaCodeGeeks";
//        String password = "unsafePassword";
//
//        Mockito.when(authenticatorMock.authenticateUser(Matchers.contains("Java"), Matchers.any(String.class))).thenReturn(false);
//        boolean actual = authenticator.authenticateUser(username, password);
//        assertFalse(actual);
//        Mockito.verify(authenticatorMock).authenticateUser(username, "unsafePassword");
//
//    }
//
//    @Test
//    public void spy() throws Exception {
//        Map<String, String> mapOne = new HashMap<>();
//        Map<String, String> spyOnMapOne = Mockito.spy(mapOne);
//
//        System.out.println(spyOnMapOne.get("key")); // Will print null.
//
//        spyOnMapOne.put("key", "A value");
//        System.out.println(mapOne.get("key"));
//        System.out.println(spyOnMapOne.get("key")); // Will print "A value".
//        System.out.println(mapOne.get("key")); // Will print "A value".
//
//        Mockito.when(spyOnMapOne.get("key")).thenReturn("Another value");
//        System.out.println(spyOnMapOne.get("key")); // Will print "Another value".
//
//
//    }
//}
