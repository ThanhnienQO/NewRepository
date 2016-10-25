/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;

import java.util.ArrayList;
import java.util.Iterator;
import org.apt.demo.bean.Person;

/**
 *
 * @author nmtien
 */
public class ArrayListDemo {
    public static void main(String[] args) {
     ArrayList aList = new ArrayList();
     for(int i=1;i<=100;i++){
        Person p = new Person(i, "Nguyen", "Van An " + i);
        aList.add(p);
     }   
     
        System.out.println("ArrayList Size: " + aList.size());
        
        Person p = (Person) aList.get(10);
        System.out.println("Thanh phan thu 11: " + p.toString());
        
        
        Person p15 = new Person(15, "Nguyen", "Van An " + 15);
        Person p15Other = new Person(15, "Nguyen", "Van An " + 15);
        System.out.println("Kiem tra hai nguoi co equals ko?: " + p15.equals(p15Other));
        System.out.println("Kiem tra P15 co ton tai trong ArrayList ko? "
                + aList.contains(p15));
        
        System.out.println("Vi tri cua Person 15: " + aList.indexOf(p15));
        
        System.out.println("Duyet theo iterator");
     Iterator ite = aList.iterator();
        
     while(ite.hasNext()){
         Person person = (Person) ite.next();
         System.out.println(person.toString());
     }
        System.out.println("Duyet theo for: ");
     for(int i=0;i<aList.size();i++){
         System.out.println(aList.get(i));
     }
        System.out.println("Duyet theo for-each");
     for(Object obj:aList){
         //Person per = (Person) obj;
         System.out.println(obj.toString());
     }
        
        
    }    
}
