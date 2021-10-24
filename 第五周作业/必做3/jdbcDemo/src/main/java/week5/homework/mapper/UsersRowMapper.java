package week5.homework.mapper;

import org.springframework.jdbc.core.RowMapper;
import week5.homework.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRowMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users user = new Users();
        user.setId(resultSet.getInt("id"));
        user.setAge(resultSet.getInt("age"));
        user.setName(resultSet.getString("name"));
        return user;
    }
}
