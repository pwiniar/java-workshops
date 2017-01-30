import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pawel on 2017-01-23.
 */
public class Queries {

    private String timestamp;

    Connection connection;

    public Queries(Connection connection) {
        this.connection = connection;
    }

    public void viewTable(Connection con) throws SQLException {

        Statement stmt = null;
        String query = "select * from USERS";

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstName = rs.getString("FIRST_NAME");
                String lastName = rs.getString("LAST_NAME");
                String profession = rs.getString("PROFESSION");
                String timeStamp = rs.getString("TIMESTAMP");

                System.out.println(firstName + " " + lastName + " " + profession + " " + timeStamp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void getLastDateAndTime(Connection connection) throws SQLException {
        String timeStamp = "";
        Statement statement = null;
        String query = "SELECT timestamp\n" +
                "FROM USERS\n" +
                "where ROWNUM = 1" +
                "order by timestamp desc\n";

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                timeStamp = rs.getString("TIMESTAMP");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
