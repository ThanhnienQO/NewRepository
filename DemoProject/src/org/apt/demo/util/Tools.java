/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author nmtien
 */
public class Tools {
    
    public static String encodeMD5(String s){
        String res = "";
            try {
            DigestUtils util = new DigestUtils();
            res = new String(util.sha256Hex(s.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }
    
    public static String encodeBase64(String s){
        String res = "";
        try {            
         res = new String(Base64.encodeBase64(s.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }
    public static String decodeBase64(String s){
        String res = "";
        try {            
         res = new String(Base64.decodeBase64(s.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return res;
    }
    
    
    
    
        public static Calendar convertString2Calendar(String s){
        Calendar cal = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date d = sdf.parse(s);
            cal = Calendar.getInstance();
            cal.setTimeInMillis(d.getTime());
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cal;
    }
    // Date; Timestamp; Calendar
    public static Timestamp convertString2Timestamp(String s){
        Timestamp ts = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            Date d = sdf.parse(s);
            
            ts = new Timestamp(d.getTime());            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ts;
    }
    
       public static String convertTimestampToString(Calendar cal){
        String s = "";
        try {            
            int iDate = cal.get(Calendar.DATE);
            int iMonth = cal.get(Calendar.MONTH) + 1;
            int iYear = cal.get(Calendar.YEAR);
            
            String sDate = (iDate < 10)?"0"+iDate:""+iDate;
            String sMonth = (iMonth < 10)?"0"+iMonth:""+iMonth;
            s = sDate + "/" + sMonth + "/"+ iYear;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }
    public static String convertTimestampToString(Timestamp ts){
        String s = "";
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(ts.getTime());
            int iDate = cal.get(Calendar.DATE);
            int iMonth = cal.get(Calendar.MONTH) + 1;
            int iYear = cal.get(Calendar.YEAR);
            
            String sDate = (iDate < 10)?"0"+iDate:""+iDate;
            String sMonth = (iMonth < 10)?"0"+iMonth:""+iMonth;
            s = sDate + "/" + sMonth + "/"+ iYear;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }
    
    
    
    public static boolean isIntegerFormat(String s){
        try {
           int n = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main1(String[] args) {
        System.out.println(Tools.isIntegerFormat("564676564"));
    }
    
    public static void main(String[] args) {
        String s = "Ha noi Aptech";
        String encodedStr = Tools.encodeBase64(s);
        System.out.println("Sau khi ma hoa: " + encodedStr);
        System.out.println("Sau khi giai ma: " + Tools.decodeBase64(encodedStr));
        System.out.println("Ma hoa SHA: " + Tools.encodeMD5(s));
    }

}
