import lombok.ToString;
import lombok.experimental.Builder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2017-01-23.
 */
public class QueriesFactory {

    @Builder
    @ToString
    public static class Employee {
        private String employee_id;
        private String first_name;
        private String last_name;
        private String department_id;
        private String hire_date;
        private String job_id;
        private String commission_pct;
        private String manager_id;
        private String phone_number;
        private String salary;



    }

    public static List<Employee> viewAllDataInTable(Connection connection, String tableName) throws SQLException {
        String query = "select * from " + tableName.toUpperCase();

        List<Employee> employees = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            employees.add(Employee.builder()
                    .employee_id(resultSet.getString("EMPLOYEE_ID"))
                    .first_name(resultSet.getString("FIRST_NAME"))
                    .last_name(resultSet.getString("LAST_NAME"))
                    .job_id(resultSet.getString("JOB_ID"))
                    .department_id(resultSet.getString("DEPARTMENT_ID"))
                    .hire_date(resultSet.getString("HIRE_DATE"))
                    .commission_pct(resultSet.getString("COMMISSION_PCT"))
                    .manager_id(resultSet.getString("MANAGER_ID"))
                    .phone_number(resultSet.getString("PHONE_NUMBER"))
                    .salary(resultSet.getString("SALARY"))
                    .build()
            );
        }
        statement.close();
        return employees;
    }

    public static int getNumberOfRowsFromTable(Connection connection, String tableName) throws SQLException {
        String query = "select count(*) as count from " + tableName.toUpperCase();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int value = -1;
        while (resultSet.next()) {
            value = resultSet.getInt("count");
        }

        statement.close();
        return value;
    }


//    public void viewTable(Connection con) throws SQLException {
//
//        Statement stmt = null;
//        String query = "select * from USERS";
//
//        try {
//            stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt("ID");
//                String firstName = rs.getString("FIRST_NAME");
//                String lastName = rs.getString("LAST_NAME");
//                String profession = rs.getString("PROFESSrON");
//                String timeStamp = rs.getString("TIMESTAMP");
//
//                System.out.println(firstName + " " + lastName + " " + profession + " " + timeStamp);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (stmt != null) {
//                stmt.close();
//            }
//        }
//    }

//    public void getLastDateAndTime(Connection connection) throws SQLException {
//        String timeStamp = "";
//        Statement statement = null;
//        String query = "SELECT timestampn" +
//                "FROM USERS\n" +
//                "where ROWNUM = 1" +
//                "order by timestamp desc\n";
//
//        try {
//            statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                timeStamp = rs.getString("TIMESTAMP");
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) {
//                statement.close();
//            }
//        }
//    }
}
