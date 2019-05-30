package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 11:46
 */
/*
    Yield 可以使线程暂停，注： 该方法可以使线程重新回到就绪状态，等待cpu调度
 */
public class ThreadYield implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+666);
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"-->"+233);
    }

    public static void main(String[] args){
        ThreadYield ty = new ThreadYield();
        new Thread(ty,"aa").start();
        new Thread(ty,"bb").start();
    }
}
