/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.bean;

import java.util.Objects;

/**
 *
 * @author nmtien
 */
public class Person implements java.io.Serializable{
    private long id;
    private String firstName;
    private String lastName;
    protected String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
    public Person() {        
    }
    
    public Person(long id) {
        this.id = id;        
    }
    public Person(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.address);
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
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    public int comparedTo(Object p) throws ClassCastException{    
        try {            
            if(!(p instanceof Person)){
                throw new ClassCastException("Invalid Object");
            }
            
            Person other = (Person)p;
            if(this.id == other.getId()){            
                if(this.firstName.equals(other.getFirstName())){                        
                    return this.lastName.compareTo(other.getLastName());
                
                }else{
                    return this.firstName.compareTo(other.getFirstName());                
                }
                
            
                
                
            }else{
                return  (int) (this.id - other.getId());
            }            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    
}
