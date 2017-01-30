import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-23.
 */
public class OperationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationSupport.class);

    interface connection {

        static void connectionTesting() {
            LOGGER.info("Oracle JDBC Connection Testing");
        }

        static void whereIsYourDriver(String driver, ClassNotFoundException e) {
            LOGGER.error("Where is your JDBC Driver?, driver: {} not found: {}", driver, e.getMessage());
        }

        static void driverRegistred(String driver) {
            LOGGER.info("Oracle JDBC Driver Registered!: {}", driver);
        }

        static void connectionNotEstablished(SQLException e) {
            LOGGER.error("Connection Failed! Check output console: {}", e.getMessage());
        }

        static void connected() {
            LOGGER.info("You made it, take control your database now!");
        }

        static void connectionFailed() {
            LOGGER.error("Failed to make connection!");
        }
    }
}
