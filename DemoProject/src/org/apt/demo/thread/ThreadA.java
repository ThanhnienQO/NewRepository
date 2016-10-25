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
public class ThreadA extends Thread{
    private long id;
    private String name;
    private int counter = 0;
    private long delayTime = 1000;
    public ThreadA(long id, String name, int counter,long delayTime) {
        this.id = id;
        this.name = name;
        this.counter = counter;
        this.delayTime =  delayTime;
    }

    public ThreadA() {
    }
    
    
    @Override
    public void run() {
        while(DemoThread.ThreadAisRunning){
            try {
                System.out.println("Thread A is running " + this.id + "-" + this.name + "-" + this.counter);
                counter ++;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    Thread.sleep(delayTime);
                } catch (Exception e) {
                }
            }
            
        }        
        
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    
}
