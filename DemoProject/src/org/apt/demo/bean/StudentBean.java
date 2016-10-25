/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.bean;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author nmtien
 */
public class StudentBean implements Comparable<Object>{
    private String firstName;
    private String lastName;
    private Timestamp birthday;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public StudentBean(String firstName, String lastName, Timestamp birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.birthday);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentBean other = (StudentBean) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }
    
    public StudentBean() {
    }

    @Override
    public int compareTo(Object o){
        if(o == null){
                throw new ClassCastException("Invalid Object");
        }
            if(!(o instanceof StudentBean)){
                throw new ClassCastException("Invalid Object");
            }
            StudentBean other = (StudentBean) o;
            int compare = this.firstName.compareToIgnoreCase(other.getFirstName());
        if(compare == 0){
            compare = this.lastName.compareToIgnoreCase(other.getLastName());
            if(compare == 0){
                return this.birthday.compareTo(other.getBirthday());            
            }else{
                return compare;
            }        
        
        }else{
            return compare;
        }
        
    }

    @Override
    public String toString() {
        return "StudentBean{" + "firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + '}';
    }
    
}
