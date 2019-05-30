package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 13:37
 */
/*
      线程的优先级
        1.MAX_PRIORITY  最大 10
        2.MIN_PRIORITY   最小 1
        3.NORM_PRIORITY  默认  5
       注：   该优先级只代表概率，优先级大说明被调度的几率大
 */
public class ThreadPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+666);
    }

    public static void main(String[] args){
        ThreadPriority tp = new ThreadPriority();

       Thread t1 = new Thread(tp,"狗眼");
        Thread t2 = new Thread(tp,"史诗");
        Thread t3 =new Thread(tp,"许愿成功");
/*
    设置优先级要在启动前设置
 */
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY-2);
        t3.setPriority(Thread.MAX_PRIORITY-9);
        t1.yield();//使用t1线程暂停，等待cpu调度
        t1.start();
        t2.start();
        t3.start();

    }
}
