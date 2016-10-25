/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apt.demo.sw.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author nmtien
 */
public class Tools {

    public static Calendar convertString2Calendar(String s) {
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

    public static Timestamp convertString2Timestamp(String s) {
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

    public static String convertTimestampToString(Calendar cal) {
        String s = "";
        try {
            int iDate = cal.get(Calendar.DATE);
            int iMonth = cal.get(Calendar.MONTH) + 1;
            int iYear = cal.get(Calendar.YEAR);

            String sDate = (iDate < 10) ? "0" + iDate : "" + iDate;
            String sMonth = (iMonth < 10) ? "0" + iMonth : "" + iMonth;
            s = sDate + "/" + sMonth + "/" + iYear;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }

    public static String convertTimestampToString(Timestamp ts) {
        String s = "";
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(ts.getTime());
            int iDate = cal.get(Calendar.DATE);
            int iMonth = cal.get(Calendar.MONTH) + 1;
            int iYear = cal.get(Calendar.YEAR);

            String sDate = (iDate < 10) ? "0" + iDate : "" + iDate;
            String sMonth = (iMonth < 10) ? "0" + iMonth : "" + iMonth;
            s = sDate + "/" + sMonth + "/" + iYear;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }

    public static boolean isIntegerFormat(String s) {
        try {
            int n = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    public static String convertSecQuantityToTime(int sec){
        String s = "";
        int minNum = 0;
        int secNum = 0;
        String sMin = "0";
        String sSec = "0";
            
        try {
            minNum = sec/60;
            secNum = sec-minNum*60;            
            sSec = (secNum < 10)?"0"+secNum:""+secNum;
            sMin = (minNum < 10)?"0"+minNum:""+minNum;            
            s = sMin + ":" + sSec;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }   
    
    
    public static void main1(String[] args) {
        System.out.println(Tools.isIntegerFormat("564676564"));
    }
    

}
