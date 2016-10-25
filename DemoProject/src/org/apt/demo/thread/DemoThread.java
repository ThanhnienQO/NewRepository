/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.apt.demo.thread;

/**
 *
 * @author nmtien
 */
public class DemoThread {
    public static boolean ThreadAisRunning = false;
    public static boolean ThreadBisRunning = false;
    
    public static void main(String[] args) {
        ThreadAisRunning = true;
        ThreadBisRunning = true;
        
        ThreadA tA = new ThreadA(123654, "Aptech", 0, 500);
       
        
        
        ThreadB tB = new ThreadB(12312123, "Ha Noi", 0,2000);        
        Thread thread = new Thread(tB);
         tA.start();
        thread.start();
        
        
    }
}
