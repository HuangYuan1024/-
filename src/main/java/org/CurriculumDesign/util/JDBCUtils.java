package org.CurriculumDesign.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author 黄愿
 *
 */
public class JDBCUtils {
    /**
     * @return SQL连接器
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/SupermarketCashierSystemDatabase?useUnicode=true&characterEncoding=utf8&useSSL=false";
            String user = "root";
            String password = "";
            String className = "com.mysql.jdbc.Driver";
            Class.forName(className);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源：连接和语句
     *
     * @param conn SQL连接器
     * @param statement SQL语句
     */
    public static void closeResources(Connection conn, Statement statement) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源：连接器、语句和结果集
     *
     * @param conn 连接器
     * @param statement 语句
     * @param rs 结果集
     */
    public static void closeResources(Connection conn, Statement statement, ResultSet rs)  {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

