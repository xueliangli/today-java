package com.xueliangli.concurrent;

public class SyncTest implements Runnable{
    private int b = 100;

    //方法锁
    private synchronized void m1() throws Exception{
        //Thread.sleep(2000);
        b = 1000;
        Thread.sleep(5000);
//        System.out.println("b = " + b);
    }

    private synchronized void m2() throws Exception {
        Thread.sleep(2500);
        b = 2000;
//        System.out.println("b = " + b);
    }

    public void run() {
        try {
            m1();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SyncTest st = new SyncTest();
        Thread t = new Thread(st);
        t.start();

        st.m2();
        System.out.println(st.b);
    }
}
