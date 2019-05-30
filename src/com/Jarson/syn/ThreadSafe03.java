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

     升级该案例，使得线程更安全，高性能
            1.将同步方法改成同步块（同步块锁的对象更加准确）
 */

public class ThreadSafe03 implements Runnable{
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
            test5();

        }
    }
    //同步块（提高性能）
    private  void test5(){
        if(ticket<=0) { //这里判断没票的时候，则不需访问同步块，直接退出
            flag = false;
            return;
        }
        /*情况一：多个线程去抢夺最后一张票的时候
                那么我们多个线程都需要去访问同步块
                 当线程a夺走后，ticket为0，其他线程访问进入同步块，发现ticket为0，直接退出
          * */
        synchronized(this){ //注：这里的this指的是ThreadSafe03的对象

            if(ticket==0){      //只剩一张票并被拿走的时候
                flag  = false;
                return;
            }else{
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket-- + "票");
            }
        }

    }
    //同步块（同步块范围太大，导致效率低下）
    private  void test4(){
        /*
            线程访问同步块中是需要时间的，那么如果没有票了的话，那还需要等待吗？
            只剩一张票的情况下，线程a进入并拿到了，现在是已经没票了，可以后面的线程还在等待
            因此，我们需要进一步处理
         */
        synchronized(this){ //注：这里的this指的是ThreadSafe03的对象
            if(ticket<=0){
                flag  = false;
                return;
            }else{
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket-- + "票");
            }
        }

    }
    //缩小同步块的锁的范围（使得线程不安全的原因：范围太小，锁不住，相当于大爷访问同步块，进行等待300毫秒，因为范围太小，没锁住，导致大妈也可以进来访问同步块，以此类推）
    private  void test3(){
        synchronized(this) { //注：这里的this指的是ThreadSafe03的对象
            if (ticket <= 0) {
                flag = false;
                return;
            }
        }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket-- + "票");



    }
    //同步块（未提高性能的）
    private  void test2(){
            synchronized(this){ //注：这里的this指的是ThreadSafe03的对象
                if(ticket<=0){
                    flag  = false;
                    return;
                }else{
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Thread.currentThread().getName()可以看到调用（调用run方法）者的名字
                    System.out.println(Thread.currentThread().getName()+"抢到了第"+ticket-- + "票");
                }
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
        ThreadSafe03 webTicket = new ThreadSafe03();
            //多个代理
        new Thread(webTicket,"大妈").start();//cpu调用当中的run方法
        new Thread(webTicket,"大爷").start();
        new Thread(webTicket,"大姐").start();


    }
}
