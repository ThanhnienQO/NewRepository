/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;
import org.apt.demo.bean.Person;

import org.apt.demo.bean.StudentBean;

/**
 *
 * @author nmtien
 */
public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<Long,Person> hashTable = new Hashtable<>();        
        for(int i=100;i>=0;i--){            
            Person p = new Person(i, "An " + i, "Nguyen Van");            
            hashTable.put(Long.valueOf(p.getId()), p);
        }
        
        Enumeration<Long> e = hashTable.keys();
        
        while(e.hasMoreElements()){
            Long key = e.nextElement();
            Person p = hashTable.get(key);
            System.out.println("Person: " + p.toString());
        }
        
        Person other = new Person(32232, "An ", "Nguyen Van");
        System.out.println("Kiem tra su ton tai trong tap hop: " + hashTable.contains(other));
        
        System.out.println("Xoa khoi tap hop: ");
        Person removedObj = hashTable.remove(Long.valueOf(12));
        
        System.out.println("Doi tuong vua bi xoa: " + removedObj.toString());
        
        
        
    }
}
