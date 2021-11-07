package week7.homework.service;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Random;
import java.util.UUID;

@Service
public class OrderBatchService extends Thread {
    public void run() {
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
            conn.setAutoCommit(false);//关闭自动提交
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 开始时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String sql = "INSERT INTO hw_order (order_id,user_id,order_time,order_price,order_pay_amount," +
                "order_status,order_prod_id,pay_card_no,bank_name,order_pay_time,req_ip,device_id,err_msg," +
                "device_type,req_mac,pay_channel,pay_flow_id,recmd_mobile,recmd_name) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Random rand = new Random();
        try {
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement  pstm = (PreparedStatement) conn.prepareStatement(sql);//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 20; i++) {
                // 第j次提交步长
                for (int j = 1; j <= 5000; j++) {
                    pstm.setString(1, UUID.randomUUID().toString().replace("-",""));
                    pstm.setString(2, "userid123");
                    pstm.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
                    pstm.setDouble(4,rand.nextDouble());
                    pstm.setDouble(5,rand.nextDouble());                    pstm.setString(6,"01");
                    pstm.setString(7,"prodId123");
                    pstm.setString(8,"cardNo123");
                    pstm.setString(9,"bankName123");
                    pstm.setTimestamp(10,new Timestamp(System.currentTimeMillis()));
                    pstm.setString(11,"ip123");
                    pstm.setString(12,"deviceId123");
                    pstm.setString(13,"交易成功");
                    pstm.setString(14,"2");
                    pstm.setString(15,"req_mac123");
                    pstm.setString(16,"1");
                    pstm.setString(17,String.valueOf(begin - i));
                    pstm.setString(18,"狗娃");
                    pstm.setString(19,"13888888888");
                    pstm.addBatch();
                }
                // 执行操作
                pstm.executeBatch();
                // 提交事务
                conn.commit();
            }
            // 头等连接
            pstm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("10万条数据插入花费时间 : " + (end - begin)+ "毫秒"+"  插入完成");
    }
}