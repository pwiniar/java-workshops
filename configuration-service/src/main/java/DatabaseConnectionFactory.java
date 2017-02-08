import tools.OperationSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class DatabaseConnectionFactory{

    public Connection getDatabaseConnection(String url, String userName, String password, String driver) {
        OperationSupport.connectionTesting();
        Connection connection = null;
        try {
            Class.forName(driver);
            OperationSupport.driverRegistred(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            OperationSupport.whereIsYourDriver(driver, e);
        } catch (SQLException e) {
            OperationSupport.connectionNotEstablished(e);
        }

        return connection;
    }
}
