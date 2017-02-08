package tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class OperationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationSupport.class);


    public static void connectionTesting() {
        LOGGER.info("Oracle JDBC Connection Testing");
    }

    public static void whereIsYourDriver(String driver, ClassNotFoundException e) {
        LOGGER.error("Where is your JDBC Driver?, driver: {} not found: {}", driver, e.getMessage());
    }

    public static void driverRegistred(String driver) {
        LOGGER.info("Oracle JDBC Driver Registered!: {}", driver);
    }

    public static void connectionNotEstablished(SQLException e) {
        LOGGER.error("Connection Failed! Check output console: {}", e.getMessage());
    }

    public static void connected() {
        LOGGER.info("You made it, take control your database now!");
    }

    static void connectionFailed() {
        LOGGER.error("Failed to make connection!");
    }

    public static void lostConnectionToDatabase() {
        LOGGER.error("Lost connection to database");
    }

    public static void somethingHappend(String cause) {
        LOGGER.error("Something happen {}", cause);
    }

    public static void retrying() {
        LOGGER.warn("Retrying ....");
    }
}
