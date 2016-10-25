/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Vector;
import org.apt.demo.bean.Person;

/**
 *
 * @author nmtien
 */
public class FileDemo {
    
    public Vector<Person> readStudentFromFile(String filePath) throws Exception{
        Vector<Person> v = new Vector<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;                
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            Object o = null;
            
            while((o = ois.readObject()) != null){
                v.add((Person)o);
            }
            
            
            
            
        } catch (EOFException eofEx) {
           return v;            
        } catch (FileNotFoundException ex) {
            throw ex;            
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            try {
                if(ois != null){
                    ois.close();
                }
                if(fis != null){
                    fis.close();
                }
            } catch (Exception e) {
            }
        }
        return v;
    }
    
    
   public boolean writeObj2File(Vector<Person> v,String filePath) throws Exception{              
       FileOutputStream fos = null;
       ObjectOutputStream oos = null;              
       try {
       fos = new FileOutputStream(filePath);
       oos = new ObjectOutputStream(fos);
       for(Person p:v){
           oos.writeObject(p);
       }
       }catch(FileNotFoundException ex){
           throw ex;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }finally{
           try {
               if(oos != null){
                   oos.flush();
                   oos.close();
               }
               if(fos != null){
                   fos.close();
               }
           } catch (Exception e) {
           }
       }
   
       return true;
   } 
    
   
    
    
    public boolean writeStudentListToFile(Vector<Person> v,String filePath) throws Exception{
        FileOutputStream fos = null;
        PrintWriter pw = null;
        BufferedWriter bw = null;        
        try {
            if(v == null){
                throw new Exception("Student List is empty");
            }
            if(filePath == null || "".equalsIgnoreCase(filePath)){
                throw new Exception("file path is invalid");
            }
            fos = new FileOutputStream(filePath,true);
            pw = new PrintWriter(fos);
            bw = new BufferedWriter(pw);
            
            for(Person p:v){
                bw.write(p.getId() + "," + p.getFirstName() + "," + p.getLastName() + "," + p.getAddress());
                bw.newLine();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            try {
                bw.flush();
                if(bw != null){
                    bw.close();
                }
                if(pw != null){
                    pw.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (Exception e) {
            }
        
        }
        return true;
    }
    
    public Vector<Person> getAllStudentFromFile(String filePath) throws Exception{
        Vector v = new Vector();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            if(filePath == null || "".equalsIgnoreCase(filePath)){
                throw new Exception("File Path is Invalid");
            }
            fis = new FileInputStream(filePath);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null){
                Person p = new Person();
                String[] arr = line.split(",");
                try {
                    p.setId(Long.parseLong(arr[0]));
                    p.setFirstName(arr[1]);
                    p.setLastName(arr[2]);
                    p.setAddress(arr[3]);
                    v.add(p);
                } catch (Exception e) {
                    continue;
                }finally{
                    line = br.readLine();   
                }
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            try {
                if(br != null){
                    br.close();                    
                }
                if(isr != null){
                    isr.close();
                }
                if(fis != null){
                    fis.close();
                }
            } catch (Exception e) {
            }
        }
        return v;
    }
    public static void main1(String[] args) {
         FileDemo fileReader = new FileDemo();
         Vector v = null;
         try {
            v = fileReader.getAllStudentFromFile("data\\dest.txt");
            if(v == null || v.size() == 0){
                System.out.println("Khong co du lieu");
                return;
            }
            for(int i=0;i<v.size();i++){
                Person p = (Person)v.get(i);
                System.out.println("Person: " + p.toString());
            }           
            
        } catch (Exception e) {
             System.out.println("Loi: " + e.getMessage());
        }
         
         
         
    }
    public static void main2(String[] args) {
        FileDemo fileWriter = new FileDemo();
        Vector<Person> v = new Vector<>();
        for(int i=0;i<100;i++){
            Person p = new Person(i+1, "An " + i, "Nguyen Van");
            p.setAddress("Ha Noi");
            v.add(p);
        }
        
        try {
            boolean res = fileWriter.writeStudentListToFile(v, "data\\dest.txt");            
            System.out.println("KQ: " + res);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        
        
    }
    
    
    public static void main3(String[] args) {
        File f = new File("D:\\ACCP");
        System.out.println("File Path " + f.getPath());            
        System.out.println("Is File" + f.isFile());
        System.out.println("File Exist?: " + f.exists());
        File[] fArr = f.listFiles();
        for(File child:fArr){
            System.out.println("Size: " + child.length());
            System.out.println("File Name: " + child.getName());
            
        }
        
        
//        f = new File("D:\\ACCP\\apache-tomcat-7.0.53.zip");
//        boolean res = f.renameTo(new File("D:\\ACCP\\nmtien.zip"));
//        System.out.println("Rename: " + res);
        
         f = new File("D:\\ACCP\\nmtien.zip");
        boolean res = f.delete();
        System.out.println("Rename: " + res);
        
    }

    public static void main4(String[] args) {
          FileDemo fileWriter = new FileDemo();
        Vector<Person> v = new Vector<>();
        for(int i=0;i<100;i++){
            Person p = new Person(i+1, "An " + i, "Nguyen Van");
            p.setAddress("Ha Noi");
            v.add(p);
        }
        
        try {
            boolean res = fileWriter.writeObj2File(v, "data\\PersonList.dat");            
            System.out.println("KQ: " + res);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        
    }
    public static void main(String[] args) {
          FileDemo fileWriter = new FileDemo();
        Vector<Person> v = null;
        
        try {
            v = fileWriter.readStudentFromFile("data\\PersonList.dat");            
            System.out.println("KQ: " + v.size());
            for(Person p:v){
                System.out.println(p.toString());
            }
            
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
        
    }

}
