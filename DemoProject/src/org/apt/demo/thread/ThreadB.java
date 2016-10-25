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
public class ThreadB implements Runnable{
    private long id;
    private String name;
    private int counter = 0;
    private long delayTime = 1000;
    public ThreadB(long id, String name, int counter,long delayTime) {
        this.id = id;
        this.name = name;
        this.counter = counter;
        this.delayTime = delayTime;
    }
    
    @Override
    public void run() {
         while(DemoThread.ThreadBisRunning){
            try {
                System.out.println("Thread B is running " + this.id + "-" + this.name + "-" + this.counter);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }
    
}
