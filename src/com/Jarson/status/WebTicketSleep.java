package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-25 14:49
 */
/*
    利用多线程模拟基本的网上抢票
          加上线程中的sleep方法
            使得线程调用时发生延时
                可以看到线程体中的错误
 */

public class WebTicketSleep implements Runnable{
    private int ticket = 100;//票数

    @Override
    public void run() {
        //线程体
            while(true){
                if(ticket<=0){
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                    System.out.println(Thread.currentThread().getName()+"-->"+ticket--);
                }
            }
    }

    public static void main(String[] args){
        //一份资源
        WebTicketSleep webTicket = new WebTicketSleep();
            //多个代理
        new Thread(webTicket,"大妈").start();//cpu调用当中的run方法
        new Thread(webTicket,"大爷").start();
        new Thread(webTicket,"大姐").start();


    }
}
