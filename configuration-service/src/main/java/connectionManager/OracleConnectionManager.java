package connectionManager;

import properties.loader.PropertiesManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Pawel on 2017-01-30.
 */
public class OracleConnectionManager implements DbManager {

    private final PropertiesManager propertiesManager;

    public OracleConnectionManager(PropertiesManager propertiesManager) {
        this.propertiesManager = propertiesManager;
        loadDriver(propertiesManager);
    }

    private static void loadDriver(PropertiesManager propertiesManager) {
        try {
            Class.forName(propertiesManager.getOracleDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection conn;
        Properties connectionProps = new Properties();
        connectionProps.put("user", propertiesManager.getOracleUserName());
        connectionProps.put("password", propertiesManager.getOraclePassword());

        switch (propertiesManager.getOracleDbms()) {
            case "mysql":
                conn = DriverManager.getConnection(
                        "jdbc:" + propertiesManager.getOracleDbms() + "://" +
                                propertiesManager.getOracleServerName() +
                                ":" + propertiesManager.getOraclePort() + "/",
                        connectionProps);
                break;
            case "derby":
                conn = DriverManager.getConnection(
                        "jdbc:" + propertiesManager.getOracleDbms() + ":" +
                                propertiesManager.getOracleBbName() +
                                ";create=true",
                        connectionProps);
                break;
            default:
                conn = DriverManager.getConnection(propertiesManager.getOracleUrl(), connectionProps);
                break;
        }
        System.out.println("Connected to database");
        return conn;
    }
}
