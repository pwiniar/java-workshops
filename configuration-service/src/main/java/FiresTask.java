import java.sql.Connection;
import java.util.TimerTask;

/**
 * Created by Pawel on 2017-01-23.
 */
public class FiresTask extends TimerTask {

    private String url;
    private String username;
    private String password;
    private String driver;
    private Connection databaseConnection;
    private DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();

    public FiresTask(String url, String username, String password, String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    @Override
    public void run() {
        if (databaseConnection == null) {
            databaseConnection = databaseConnectionFactory.getDatabaseConnection(url, username, password, driver);
        } else {
            OperationSupport.connection.connected();
        }
    }
}
