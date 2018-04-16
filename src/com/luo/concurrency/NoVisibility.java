package com.luo.concurrency;

public class NoVisibility {
    private static boolean  ready;
    private static int number;

    private static class RearderThread extends  Thread{
        public void run(){
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
            System.out.println("00000000");
        }
    }

    public static void main(String[] args) {
        new RearderThread().start();
        ready = true;
        number = 42;
    }
}
