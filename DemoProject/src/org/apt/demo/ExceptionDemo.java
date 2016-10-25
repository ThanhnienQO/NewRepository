/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;

/**
 *
 * @author nmtien
 */
public class ExceptionDemo {
    
    public double div(double a,double b) throws Exception{        
        if(b == 0){
            throw new Exception("Devide by zero");
        }
        return a/b;    
    }
    
    public static int convertStringToInt(String s)  throws Exception{
        int res = -1;
        try {
            res = Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return res;
    }
    public static void main(String[] args) {
         ExceptionDemo demo = new ExceptionDemo();
         
         try {
            double res = demo.div(10, 3);
            
             System.out.println("res: " + res);
        } catch (Exception e) {
             System.out.println("Loi: " + e.getMessage());
        }
            
    }
    
    public static void main2(String[] args) {
        try {
            // Open file
            
            
           
            
            // Thuc thi
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
         // Close file
        }
    }
    public static void main1(String[] args) {
        try {
            String s = "234r2132";
            int n = Integer.parseInt(s);
            System.out.println("KQ: " + n);
        } catch (NullPointerException e) {
          //  e.printStackTrace();
            System.out.println("Loi: " + e.getMessage());
        } catch (Exception ex) {
          //  e.printStackTrace();
            System.out.println("Loi: " + ex.getMessage());
        }
    }
}
