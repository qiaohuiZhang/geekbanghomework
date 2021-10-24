package week5.homework.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import week5.homework.entity.Users;
import week5.homework.mapper.UsersRowMapper;
import week5.homework.service.UserService;

import java.sql.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean inserUser(String name, Integer age) {
        int update = jdbcTemplate.update("insert into users values(null,?,?);", name, age);
        return update > 0 ? true : false;
    }

    public Users userQry(Integer id) {
        String sql = "select * from users where id = ? ";
        List<Users> users = jdbcTemplate.query(sql, new Object[]{id}, new UsersRowMapper());
        Users user = null;
        if (!users.isEmpty()) {
            user = users.get(0);
        }
        return user;
    }

    public int updateUser(Users user) {
        String sql = "update users set name=?,age=? where id=?";
        int res = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setInt(2, user.getAge());
                preparedStatement.setInt(3, user.getId());
            }
        });
        return res;
    }

    public int deleteUser(Integer id) {
        String sql = "delete from users where id = ?";
        return jdbcTemplate.update(sql, id);
    }


    public void selUsers(Integer ageParam) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection ct = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.得到连接
            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            //3.创建PreparedStatement
            ps = ct.prepareStatement("select * from users where age=?");

            ps.setInt(1, ageParam);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                System.out.println("id="+id + "; name=" + name + "；age=" + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
