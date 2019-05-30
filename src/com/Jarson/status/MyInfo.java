package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 14:15
 */
/*
    线程中一些其他的方法
        1.Thread.currentThread();  当前线程对象
        2.setName()   getName();  代理名字
        3.isAlive（）  线程是否活着
 */
public class MyInfo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        MyInfo myInfo = new MyInfo();
        Thread t = new Thread(myInfo);
        t.setName("代打哥");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}
