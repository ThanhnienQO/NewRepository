/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;
import org.apt.demo.bean.StudentBean;

/**
 *
 * @author nmtien
 */
public class DBTools {
    public int deleteStudentInDB(String keyword){
        int res = -1;
        Connection conn = null;
        PreparedStatement stmt = null; 
        String sqlDelete = "Delete tblStudent where userName like '%" + keyword + "%'";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlDelete);            
            res = stmt.executeUpdate();            
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally{
            MyConnection.closeConnection(conn, stmt, null);
        }
        return res;    
    }
    public int updateStudentInDB(String oldName,String newName){
        int res = -1;
        Connection conn = null;
        PreparedStatement stmt = null; 
        String sqlUpdate = "Update tblStudent set UserName = ? where UserName = ?";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlUpdate);
            
            stmt.setString(1,newName);            
            stmt.setString(2,oldName);
            
            res = stmt.executeUpdate();            
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally{
            MyConnection.closeConnection(conn, stmt, null);
        }
        return res;    
    }
    public boolean updateStudent(String oldName,String newName){        
        Connection conn = null;
        PreparedStatement stmt = null; 
        String sqlUpdate = "Update tblStudent set UserName = ? where UserName = ?";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlUpdate);
            
            stmt.setString(1,newName);            
            stmt.setString(2,oldName);
            
            return stmt.execute();            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            MyConnection.closeConnection(conn, stmt, null);
        }
        
    }
    
     public boolean deleteStudent(String keyword){        
        Connection conn = null;
        PreparedStatement stmt = null; 
        String sqlDelete = "Delete tblStudent where UserName like '%" + keyword + "%'";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlDelete);
            return stmt.execute();            
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            MyConnection.closeConnection(conn, stmt, null);
        }
        
    }
     public int insertStudent2DBInTransaction(){
        int res = 1;
        Connection conn = null;
        PreparedStatement stmt = null; 
        boolean isError = false;
        String sqlInsert = "Insert into tblStudent (UserName,Birthday,Address) values (?,?,?)";
        try {
            conn = MyConnection.getConnection();
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement(sqlInsert);
            
        for(int i=1;i<=500;i++){
            Timestamp bod = new Timestamp(System.currentTimeMillis() - 1000*3600*24*50*i);
            stmt.setString(1, "Tran Thi Binh");
            stmt.setTimestamp(2, bod);
            stmt.setString(3, "Hue");
            res = stmt.executeUpdate(); 
            
//            if(i==200){
//                isError = true;
//                break;
//            }
            
            
            if(res == 0){
                isError = true;
            }
            stmt.clearParameters();
        }
            
        } catch (Exception e) {
            e.printStackTrace();
            isError = true;
            return -1;
        }finally{
            try {
                if(isError){
                    conn.rollback();
                }else{
                    conn.commit();
                }
                conn.setAutoCommit(true);
            } catch (Exception e) {
            }
            MyConnection.closeConnection(conn, stmt, null);
        }
        return res;    
    }
     public int[] insertStudent2DBInBatch(){
        int[] res = null;
        Connection conn = null;
        PreparedStatement stmt = null; 
        boolean isError = false;
        String sqlInsert = "Insert into tblStudent (UserName,Birthday,Address) values (?,?,?)";
        try {
            conn = MyConnection.getConnection();
            conn.setAutoCommit(false);
            
            stmt = conn.prepareStatement(sqlInsert);
            
        for(int i=1;i<=500;i++){
            Timestamp bod = new Timestamp(System.currentTimeMillis() - 1000*3600*24*50*i);
            stmt.setString(1, "Tran Thi Binh");
            stmt.setTimestamp(2, bod);
            stmt.setString(3, "Hue");
            stmt.addBatch(); 
            stmt.clearParameters();
        }

            res = stmt.executeBatch();
        
        } catch (Exception e) {
            e.printStackTrace();
            isError = true;
            return null;
        }finally{
            try {
                if(isError){
                    conn.rollback();
                }else{
                    conn.commit();
                }
                conn.setAutoCommit(true);
            } catch (Exception e) {
            }
            MyConnection.closeConnection(conn, stmt, null);
        }
        return res;    
    }
    public int insertStudent2DB(String userName,Timestamp bod,String address){
        int res = -1;
        Connection conn = null;
        PreparedStatement stmt = null; 
        String sqlInsert = "Insert into tblStudent (UserName,Birthday,Address) values (?,?,?)";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlInsert);
            
            stmt.setString(1, userName);
            stmt.setTimestamp(2, bod);
            stmt.setString(3, address);
            
            res = stmt.executeUpdate();            
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }finally{
            MyConnection.closeConnection(conn, stmt, null);
        }
        return res;    
    }

    public Vector getAllStudent(){
        Vector v = new Vector();
           Connection conn = null;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        String sqlSelect = "Select UserName,Birthday,Address from tblStudent";
        try {
            conn = MyConnection.getConnection();
            stmt = conn.prepareStatement(sqlSelect);
            rs = stmt.executeQuery();
            while(rs.next()){
                StudentBean std = new StudentBean();
                std.setFirstName(rs.getString(1));                
                std.setBirthday(rs.getTimestamp("Birthday"));
                std.setAddress(rs.getString(3));
                v.add(std);
            }            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            MyConnection.closeConnection(conn, stmt, rs);
        }
        return v;
    }
    
    
    public static void main1(String[] args) {
        DBTools dbTool = new DBTools();
        
        for(int i=1;i<=500;i++){
            Timestamp bod = new Timestamp(System.currentTimeMillis() - 1000*3600*24*50*i);
            int res = dbTool.insertStudent2DB("Nguyen Van A " + i, bod,"So nha " + i + " Ba Dinh");
            System.out.println("KQ: " + res);
        }
    }
    
    public static void main2(String[] args) {
         DBTools dbTool = new DBTools();
         Vector v = dbTool.getAllStudent();
         System.out.println("KQ: " + v.size());
    }
 public static void main3(String[] args) {
         DBTools dbTool = new DBTools();
         //int res = dbTool.updateStudentInDB("Nguyen Van A zxxx", "Gia tri moi");
         boolean res = dbTool.updateStudent("Nguyen Van A zxxx", "Gia tri moi");
         
         System.out.println("KQ: " + res);
    }
 public static void main4(String[] args) {
         DBTools dbTool = new DBTools();
        // int res = dbTool.deleteStudentInDB("Nguyen Van");
         boolean res = dbTool.deleteStudent("Nguyen Van A zxxx");         
         System.out.println("KQ: " + res);
    }
  public static void main(String[] args) {
         DBTools dbTool = new DBTools();
       // dbTool.insertStudent2DBInTransaction();
          int[] res = dbTool.insertStudent2DBInBatch();
          System.out.println(res.length + "-" + res[232]);
          
    }
}
