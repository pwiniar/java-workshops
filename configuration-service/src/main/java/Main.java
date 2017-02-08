import connectionManager.OracleConnectionManager;
import properties.loader.PropertiesManager;
import tools.OperationSupport;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        PropertiesManager propertiesManager = new PropertiesManager();
        OracleConnectionManager oracleConnectionManager = new OracleConnectionManager(propertiesManager);
        Connection connection = null;
        boolean testFlat = true;

        while (testFlat) {
            connection = connectionEstablisher(oracleConnectionManager, connection);

            while (connection.isValid(5)) {

            }
            connection = null;
            connection = connectionEstablisher(oracleConnectionManager, connection);
        }


    }

    private static Connection connectionEstablisher(OracleConnectionManager oracleConnectionManager, Connection connection) {
        while (connection == null) {
            connection = oracleConnectionManager.getConnection();
            if (connection != null) {
                OperationSupport.connected();
            }
        }
        return connection;
    }
}
