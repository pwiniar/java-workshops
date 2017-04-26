package api.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pawel on 2017-04-26.
 */
public class StudnetMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int i) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age")

        );
    }
}
