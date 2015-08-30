/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Md Mamin
 */
public class DBconn {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/pointofsale";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;

    public Connection getConnection() {

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
        }
    }

    public ResultSet getResultSet(String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException sqe) {
            rs = null;
        }
        return rs;
    }

    public boolean insertData(String sql) {
        Statement stmt = null;
        try {
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException sqe) {
            return false;
        }
    }

}
