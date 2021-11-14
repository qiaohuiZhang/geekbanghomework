package week8.homework.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import week8.homework.service.OrderService;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void inserOrder() {
        String sql="insert into t_order(user_id,status)" +
                " values(?,?)";
        for(int i = 1; i<50; i++){
            jdbcTemplate.update(sql,i,"ok");
        }
    }


    @Override
    public void getOrders() {
        String sql = "select * from t_order";
        List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
        for (Map m:lists) {
            System.out.println(m.get("order_id") + "===" + m.get("user_id") + "====" + m.get("order_id"));
        }
    }
//
//    public int updateUser(Orders user) {
//        String sql = "update users set name=?,age=? where id=?";
//        int res = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setInt(2, user.getAge());
//                preparedStatement.setInt(3, user.getId());
//            }
//        });
//        return res;
//    }
//
//    public int deleteUser(Integer id) {
//        String sql = "delete from users where id = ?";
//        return jdbcTemplate.update(sql, id);
//    }
//
//
//    public void selUsers(Integer ageParam) {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection ct = null;
//        try {
//            //1.加载驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2.得到连接
//            ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
//            //3.创建PreparedStatement
//            ps = ct.prepareStatement("select * from users where age=?");
//
//            ps.setInt(1, ageParam);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                int age = rs.getInt(3);
//                System.out.println("id="+id + "; name=" + name + "；age=" + age);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (ps != null) {
//                    ps.close();
//                }
//                if (ct != null) {
//                    ct.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
