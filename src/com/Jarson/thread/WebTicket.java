package com.Jarson.thread;

/**
 * @author Jarson
 * @create 2019-05-25 14:49
 */
/*
    利用多线程模拟基本的网上抢票

 */

public class WebTicket implements Runnable{
    private int ticket = 100;//票数

    @Override
    public void run() {
        //线程体
            while(true){
                if(ticket<=0){
                    break;
                }else{
                    //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                    System.out.println(Thread.currentThread().getName()+"-->"+ticket--);
                }
            }
    }

    public static void main(String[] args){
        //一份资源
        WebTicket webTicket = new WebTicket();
            //多个代理
        new Thread(webTicket,"大妈").start();//cpu调用当中的run方法
        new Thread(webTicket,"大爷").start();
        new Thread(webTicket,"大姐").start();


    }
}
