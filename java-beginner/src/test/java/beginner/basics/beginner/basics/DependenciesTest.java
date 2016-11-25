package beginner.basics.beginner.basics;

import org.assertj.core.api.Assertions;
import org.mockito.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by michal on 15.06.2016.
 */
public class DependenciesTest {

    public static class Service {

        private Database database;
        private RemoteService service;

        public Service(Database database, RemoteService service) {
            this.database = database;
            this.service = service;
        }

        public void doBusinessStuff() {
            String data = database.readData();
            String dataToSend = data + " to send";
            service.doYourJob(dataToSend);
        }
    }

    public static class Database {

        public String readData() {
            throw new RuntimeException("no connection to database");
        }
    }

    public static class RemoteService {

        public void doYourJob(String data) {

        }
    }

    @Mock
    Database mockedDatabase;
    @Mock
    RemoteService mockedService;
    @Captor
    ArgumentCaptor<String> captor;
    @InjectMocks
    Service serviceUnderTests;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoBusinessStuffFromService() throws Exception {
        Mockito.when(mockedDatabase.readData()).thenReturn("fake repository");

        serviceUnderTests.doBusinessStuff();

        Mockito.verify(mockedService).doYourJob(captor.capture());

        Assertions.assertThat(captor.getValue()).isEqualTo("fake repository to send");
    }
}
