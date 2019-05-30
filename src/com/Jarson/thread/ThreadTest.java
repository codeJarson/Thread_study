package com.Jarson.thread;
import java.lang.Thread;
/**
 * @author Jarson
 * @create 2019-05-25 11:03
 */
/*
    多线程的创建与实现
        1.创建：我们需要继承Thread类，并重写run方法（注：Thread类实现了Runnable接口）
        2.实现：Thread类中有着start方法。（相当于开辟一条新的线程，可与主线程同时执行）
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Listening music");
        }
    }

    public static void main(String[] args){//该为主线程
        //创建子类对象
        ThreadTest tt = new ThreadTest();
        /*
            start方法可以调用当中的run方法，不过什么时候调用使用cpu类决定的
         */
        tt.start(); //启动线程
        //主线程与第二条线程同时执行
        for (int i = 0; i <50; i++) {
            System.out.println("Coding");
        }
    }
}
