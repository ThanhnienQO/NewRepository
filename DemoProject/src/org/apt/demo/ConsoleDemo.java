/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;


import java.util.Scanner;
import org.apt.demo.bean.Person;
import org.apt.demo.util.Tools;

/**
 *
 * @author nmtien
 */
public class ConsoleDemo {
    
    
    
    public int getIntValueFromConsole(){
        int res = 0;
        System.out.println("Ban hay nhap mot so nguyen");
        while(true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if(Tools.isIntegerFormat(s)){
                res = Integer.parseInt(s);
                return res;
            }else{
            System.out.println("Ban phai nhap lai so nguyen");
            continue;
            }
        
        }
        
        
    }
    
    public static void main3(String[] args) {
        ConsoleDemo consoleDemo = new ConsoleDemo();
                
        int n = consoleDemo.getIntValueFromConsole();
        System.out.println("Ban vua nhap: " + n);
    }
    
    
    public static void main2(String[] args) {
        try {
          Scanner scanner = new Scanner(System.in);
          
            System.out.println("Ban hay nhap mot so nguyen: ");
            int n = scanner.nextInt();
            System.out.println("Ban da nhap: " + n);
          
          
                    
        } catch (Exception e) {
            System.out.println("Loi nhap lieu: " + e.getMessage());
        }
    }
    
    
    public static void main1(String[] args) {
        Person person1 = new Person();
        System.out.println("Persion 1 has ID: " + person1.getId());
        
        
        Person person2 = new Person(123456);
        System.out.println("Persion 2 has ID: " + person2.getId());
        
        Person person3 = new Person(123, "Nguyen", "Van An");
       
        System.out.println("Person 3: "  + person3.getId() + "-" + person3.getFirstName() + "-" + person3.getLastName());
        System.out.println("Person Info: " + person3.toString());
    }
    public static void main(String[] args) {
        for(String s:args){
            System.out.println("Tham so: " + s);
        }
    }
    
}
