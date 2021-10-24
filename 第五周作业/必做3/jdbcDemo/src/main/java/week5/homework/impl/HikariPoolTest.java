package week5.homework.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class HikariPoolTest {

    private static final HikariDataSource ds;

    static {
        HikariConfig conf = new HikariConfig();
        conf.setUsername("root");
        conf.setPassword("root");
        conf.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds = new HikariDataSource(conf);
    }

    public void selUsers(Integer ageParam) {
        long st = System.currentTimeMillis();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection ct = null;
        try {
            for (int i = 0; i < 10; i++) {
                ct = ds.getConnection();
                ps = ct.prepareStatement("select * from users where age=?");
                ps.setInt(1, ageParam);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int age = rs.getInt(3);
                    System.out.println("id=" + id + "; name=" + name + "；age=" + age);
                }
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