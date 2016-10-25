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
public class SystemDemo {
    public static void main(String[] args) {
        Runtime rTime = Runtime.getRuntime();
        try {
            Process p = rTime.exec("calc");
            Thread.sleep(1000*30);
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
