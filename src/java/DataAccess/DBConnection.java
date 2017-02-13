/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vinod-pt1457
 */
public class DBConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/librarymanagement";
        //  Database credentials
        final String USER = "root";
        final String PASS = "asdfghjkl";
        //loading drivers for mysql
        Class.forName(JDBC_DRIVER);
        //creating connection with the database
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        return con;
    }
}
