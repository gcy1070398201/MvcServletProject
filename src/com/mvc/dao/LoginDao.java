package com.mvc.dao;

import com.mvc.bean.LoginBean;

import java.sql.*;

/**
 * 操作数据库
 */
public class LoginDao {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/user";

//     MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC";
    public static int login(LoginBean loginBean){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;
        int result=-1;
        try {
            Class.forName(JDBC_DRIVER);
            connection=DriverManager.getConnection(DB_URL,"root","123456");
            String sql="SELECT count(*)  FROM user_login WHERE uname=? AND upsd=? ";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,loginBean.getUname());
            preparedStatement.setString(2,loginBean.getUpsd());
            rs=preparedStatement.executeQuery();
            if (rs.next()){
                result=rs.getInt(1);
            }
            if (result>0){
                result =1;
            }else{
                result =0;
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            result =-1;
        } catch (SQLException e) {
            e.printStackTrace();
            result =-1;
        }finally {
                try {
                    if (rs!=null)rs.close();
                    if (preparedStatement!=null)preparedStatement.close();
                    if (connection!=null)connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
          return result;
    }
}
