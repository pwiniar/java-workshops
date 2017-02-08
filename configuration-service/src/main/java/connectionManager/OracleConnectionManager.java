package connectionManager;

import properties.loader.PropertiesManager;
import tools.OperationSupport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Pawel on 2017-01-30.
 */
public class OracleConnectionManager implements DbManager {

    private final PropertiesManager propertiesManager;
    private final Properties connectionProps = new Properties();
    List<String> exceptions = new LinkedList<>();

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
    public Connection getConnection() {
        Connection conn = null;
        connectionProps.put("user", propertiesManager.getOracleUserName());
        connectionProps.put("password", propertiesManager.getOraclePassword());

        try {
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

        } catch (SQLException e) {
            if (!exceptions.contains(e.getMessage())) {
                exceptions.add(e.getMessage());
                OperationSupport.somethingHappend(e.getMessage());
            }
        }
        return conn;
    }
}
