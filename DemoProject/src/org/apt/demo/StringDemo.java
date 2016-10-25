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
public class StringDemo {
    public static void main1(String[] args) {
        String s = " Xin chao Ha noi Aptech! Welcome to Ha noi Aptech ";
        
        System.out.println("Length of string: " + s.length());
        System.out.println("To LowerCase: " + s.toLowerCase());
        System.out.println("To Upper Case: " + s.toUpperCase());
        System.out.println("First sub string index: " + s.indexOf("Aptech"));;
        System.out.println("Last sub string index: " + s.lastIndexOf("Aptech"));;
        System.out.println("Index of: World: " + s.indexOf("World"));
        System.out.println("Sub string 0-10: " + s.substring(0,10));        
        System.out.println("Sub String From index 15: " + s.substring(15));
        System.out.println("Char at index 20: " + s.charAt(20));
        System.out.println("Replace First Aptech word by Apt" + s.replaceFirst("Aptech", "Apt"));
        System.out.println("Replace All Aptech word by Apt" + s.replaceAll("Aptech", "Apt"));
        System.out.println("Trim space: " + s.trim());
        
        System.out.println("Compare: " + "Hanoi".compareTo("Viet Name")); // >0: a>b; 0: a=b; <0: a<b
        System.out.println("Compare ignore case: " + "Hanoi".compareToIgnoreCase("hanoi"));
        
        System.out.println("Compare equals: " + "Ha Noi".equals("Viet Name"));  //return true/false
        System.out.println("Compare equals: " + "Ha Noi".equalsIgnoreCase("ha noi"));  //return true/false
        String[] sArr = s.split("\\s+");
        System.out.println("Quantity of Word:  " + sArr.length);
        for(int i=0;i<sArr.length;i++){
            System.out.println("word " + i + ": " + sArr[i]);
        }
        
        System.out.println("Check start with Ha noi: " + s.startsWith("Ha noi"));
        
    }
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("start");        
        
        System.out.println("After Append: " + sb.append(" Hello Ha Noi"));
        System.out.println("After delete: " + sb.delete(4, 6));
        System.out.println("After insert to index 2: " + sb.insert(2, "Vi Tri So 2"));
        sb = new StringBuilder("Xin chao Ha Noi");
        sb = sb.reverse();
        System.out.println("After reverse: " + sb);
    }
}
