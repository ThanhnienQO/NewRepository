/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.TreeSet;
import org.apt.demo.bean.StudentBean;
import org.apt.demo.bean.TeacherBean;
import org.apt.demo.util.MyComparator;

/**
 *
 * @author nmtien
 */
public class TreeSetDemo {
    public static void main1(String[] args) {
        TreeSet treeSet = new TreeSet();
        for(int i=100;i>=0;i--){
            long delta = 1000*3600*24*50;
            StudentBean std = new StudentBean("An " + i, "Nguyen Van", new Timestamp(System.currentTimeMillis()-delta));
            treeSet.add(std);
        }
        
        Iterator ite = treeSet.iterator();
        while(ite.hasNext()){
            StudentBean obj = (StudentBean)ite.next();
            System.out.println(obj.toString());
        }
        
        
    }
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new MyComparator());
        for(int i=100;i>=0;i--){
            long delta = 1000*3600*24*50;
            TeacherBean s = new TeacherBean("An " + i, "Nguyen Van", new Timestamp(System.currentTimeMillis()-delta));
            treeSet.add(s);
        }
        
        Iterator ite = treeSet.iterator();
        while(ite.hasNext()){
            TeacherBean obj = (TeacherBean)ite.next();
            System.out.println(obj.toString());
        }
        
        
    }
}
