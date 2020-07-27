package com.flydean.input;

import java.sql.*;
import java.util.Base64;

/**
 * @author wayne
 * @version SQLInjection,  2020/7/26
 */
public class SQLInjection {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?characterEncoding=UTF-8", "root", "");
            System.out.println("数据库连接成功");
          return con;
    }

    public String encodePassword(char[] password){
        return Base64.getEncoder().encodeToString(new String(password).getBytes());
    }

    public void jdbcWithInjection(String username,char[] password) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String pwd = encodePassword(password);

            String sqlString = "SELECT * FROM user WHERE username = '"
                    + username +
                    "' AND password = '" + pwd + "'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);

            if (!rs.next()) {
                throw new SecurityException(
                        "User name or password incorrect"
                );
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
            }
        }
    }
    public void jdbcWithPrepareStatementInjection(String username,char[] password) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String pwd = encodePassword(password);

            String sqlString = "SELECT * FROM user WHERE username = '"
                    + username +
                    "' AND password = '" + pwd + "'";
            PreparedStatement stmt = connection.prepareStatement(sqlString);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new SecurityException(
                        "User name or password incorrect"
                );
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
            }
        }
    }
    public void jdbcWithPrepareStatement(String username,char[] password) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String pwd = encodePassword(password);

            String sqlString =
                    "select * from user where username=? and password=?";
            PreparedStatement stmt = connection.prepareStatement(sqlString);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                throw new SecurityException(
                        "User name or password incorrect"
                );
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
            }
        }
    }
}
