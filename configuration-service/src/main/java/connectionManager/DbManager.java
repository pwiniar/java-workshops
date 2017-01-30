package connectionManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-01-30.
 */
public interface DbManager {

    Connection getConnection() throws SQLException;
}
