package com.Jarson.syn;

/**
 * @author Jarson
 * @create 2019-05-25 14:49
 */
/*
    利用多线程模拟基本的网上抢票
    通过synchronized锁上对象的资源，那么就可以使得
    线程同步（一个对象，多个线程的使用）的同时并发
    synchronized方法：其实锁的是对象的资源
                    注：锁的不准确，则会连线程也锁死
                        同步方法中不能有while等语句循环
 */

public class ThreadSafe implements Runnable{
    private int ticket = 100;//票数
    private boolean flag = true;
    @Override
    public   void run() {
        //线程体
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(flag){
            test();

        }
    }
    //同步方法
    private synchronized void test(){

            if(ticket<=0){
                flag  = false;
                return;
            }else{
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket-- + "票");
            }

    }

    public static void main(String[] args){
        //一份资源
        ThreadSafe webTicket = new ThreadSafe();
            //多个代理
        new Thread(webTicket,"大妈").start();//cpu调用当中的run方法
        new Thread(webTicket,"大爷").start();
        new Thread(webTicket,"大姐").start();


    }
}
