import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class DatabaseConnectionFactory implements OperationSupport.connection{

    public Connection getDatabaseConnection(String url, String userName, String password, String driver) {
        OperationSupport.connection.connectionTesting();
        Connection connection = null;
        try {
            Class.forName(driver);
            OperationSupport.connection.driverRegistred(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            OperationSupport.connection.whereIsYourDriver(driver, e);
        } catch (SQLException e) {
            OperationSupport.connection.connectionNotEstablished(e);
        }

        return connection;
    }
}
