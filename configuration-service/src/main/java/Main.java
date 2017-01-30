import connectionManager.OracleConnectionManager;
import properties.loader.PropertiesManager;

import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        PropertiesManager propertiesManager = new PropertiesManager();
        OracleConnectionManager oracleConnectionManager = new OracleConnectionManager(propertiesManager);
        oracleConnectionManager.getConnection();


//        Timer timer = new Timer();
//        FiresTask task = new FiresTask(URL, USERNAME, PASSWORD, DRIVER);
//        timer.schedule(task, 0, 10000);

//        Connection databaseConnection = databaseConnectionFactory.getDatabaseConnection(URL, USERNAME, PASSWORD, DRIVER);
//        Queries queries = new Queries(databaseConnection);
//
//        queries.viewTable(databaseConnection);


    }

}
