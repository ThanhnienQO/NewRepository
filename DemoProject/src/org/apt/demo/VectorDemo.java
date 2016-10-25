/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;

import java.util.Iterator;
import java.util.Vector;
import org.apt.demo.bean.Person;

/**
 *
 * @author nmtien
 */
public class VectorDemo {
    public static void main(String[] args) {
     Vector<Person> v = new Vector<>();
     for(int i=1;i<=100;i++){
        Person p = new Person(i, "Nguyen", "Van An " + i);
        v.add(p);
     }   
     
        System.out.println("Vector Size: " + v.size());
        
        Person p = v.get(10);
        System.out.println("Thanh phan thu 11: " + p.toString());
        
        
        Person p15 = new Person(15, "Nguyen", "Van An " + 15);
        Person p15Other = new Person(15, "Nguyen", "Van An " + 15);
        System.out.println("Kiem tra hai nguoi co equals ko?: " + p15.equals(p15Other));
        System.out.println("Kiem tra P15 co ton tai trong Vector ko? "
                + v.contains(p15));
        
        System.out.println("Vi tri cua Person 15: " + v.indexOf(p15));
        
        System.out.println("Duyet theo iterator");
     Iterator ite = v.iterator();
        
     while(ite.hasNext()){
         Person person = (Person) ite.next();
         System.out.println(person.toString());
     }
        System.out.println("Duyet theo for: ");
     for(int i=0;i<v.size();i++){
         System.out.println(v.get(i));
     }
        System.out.println("Duyet theo for-each");
     for(Object obj:v){
         //Person per = (Person) obj;
         System.out.println(obj.toString());
     }
        
        
    }    
}
