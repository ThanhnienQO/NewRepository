/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author nmtien
 */
public class MyConnection {
    
    private static String userName  = "lab";
    private static String password  ="";
    private static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static String connString = "jdbc:odbc:StudentDSN";
    
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(connString, userName, password);                    
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    
    
    public static void closeConnection(Connection conn,PreparedStatement stmt,ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
        }
    
    }
    
    
    public static void main(String[] args) {
        Connection conn = MyConnection.getConnection();
        System.out.println("KQ: " + conn.toString());
    }
    
}
