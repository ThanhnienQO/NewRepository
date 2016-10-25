/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author nmtien
 */
public class ConfigLoader {
    Properties prop = new Properties();
    
    public boolean readConfigFile(String filePath){
        FileInputStream fis = null;
        try {            
            fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (Exception e) {
            }
        }    
        return true;
    }
    public String getStringValue(String key){
        return prop.getProperty(key);
    }
    public int getIntValue(String key){
        int res = -1;
        try {
           res = Integer.parseInt(prop.getProperty(key));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return res;
    }
    public static void main(String[] args) {
        ConfigLoader loader = new ConfigLoader();
        boolean res = loader.readConfigFile("data\\conf.properties");
        System.out.println("KQ :"+res);
        String val = loader.getStringValue("ACCEPTED_IP");
        System.out.println("ACCEPTED_IP: " + val);
    }

}

