/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.util;

import java.util.Comparator;
import org.apt.demo.bean.StudentBean;
import org.apt.demo.bean.TeacherBean;

/**
 *
 * @author nmtien
 */
public class MyComparator implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
          if(o1 == null || o2 == null){
              throw new ClassCastException("Invalid Object");
          }  
          if(!(o1 instanceof TeacherBean) || !(o2 instanceof TeacherBean)){
              throw new ClassCastException("Invalid Object");
          }
          
          TeacherBean s1 = (TeacherBean) o1;
          TeacherBean s2 = (TeacherBean) o2;
          
          int compare = s1.getFirstName().compareTo(s2.getFirstName());
          if(compare == 0){
              compare = s1.getLastName().compareTo(s2.getLastName());
              if(compare == 0){
                  return s1.getBirthday().compareTo(s2.getBirthday());
              }else{
                  return compare;
              }              
          }else{
              return compare;
          }
          
          
          
          
          
          
          
    }
    
}
