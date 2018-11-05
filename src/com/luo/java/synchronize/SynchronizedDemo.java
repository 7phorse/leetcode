package com.luo.java.synchronize;

public class SynchronizedDemo {

    private Object lock;

    public SynchronizedDemo(Object lock) {
        this.lock = lock;
    }

    public static int x=0;

    public synchronized void demo(){

    }

    public void demo1(){
        int a = 0;
    }

    public void demo3(){
        synchronized (SynchronizedDemo.class){

        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();
        for (int i = 0; i <10 ; i++) {
            new Thread(() ->{
               SynchronizedDemo sd = new SynchronizedDemo(lock);
               sd.demo3();
            }).start();
        }

    }
}
