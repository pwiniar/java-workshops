package db.triger;

import connectionManager.OracleConnectionManager;
import properties.loader.PropertiesManager;
import tools.OperationSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-02-15.
 */


public class DbTrigger {

    public static void logSal(int empID, float oldSal, float newSal) throws SQLException {
        PropertiesManager propertiesManager = new PropertiesManager();
        OracleConnectionManager oracleConnectionManager = new OracleConnectionManager(propertiesManager);
        Connection connection = null;

        connection = connectionEstablisher(oracleConnectionManager, connection);
        String sql = "INSERT INTO sal_audit VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, empID);
            pstmt.setFloat(2, oldSal);
            pstmt.setFloat(3, newSal);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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
