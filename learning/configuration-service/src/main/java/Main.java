import connectionManager.OracleConnectionManager;
import properties.loader.PropertiesManager;
import tools.OperationSupport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Pawel on 2017-01-23.
 */
public class Main {

    private static int initialNumberOfRecords;

    public static void main(String[] args) throws SQLException {

        PropertiesManager propertiesManager = new PropertiesManager();
        OracleConnectionManager oracleConnectionManager = new OracleConnectionManager(propertiesManager);
        Connection connection = null;

        connection = connectionEstablisher(oracleConnectionManager, connection);
//        List<QueriesFactory.Employee> employees = QueriesFactory.viewAllDataInTable(connection, "employees");
//        employees.forEach(System.out::println);
//        System.out.println(QueriesFactory.getNumberOfRowsFromTable(connection, "employees"));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        initialNumberOfRecords = QueriesFactory.getNumberOfRowsFromTable(connection, "employees");
        System.out.println("Initial number of records " + initialNumberOfRecords);

        Connection finalConnection = connection;
        executorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                int numberOfRowsFromTable = 0;
                try {
                    numberOfRowsFromTable = QueriesFactory.getNumberOfRowsFromTable(finalConnection, "employees");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (numberOfRowsFromTable > initialNumberOfRecords) {
                    System.out.println("Got new update: number of records :" + numberOfRowsFromTable);
                    initialNumberOfRecords = numberOfRowsFromTable;
                }
            }
        }, 10, 5, TimeUnit.MINUTES);

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
