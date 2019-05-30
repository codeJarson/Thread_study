package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 13:13
 */
/*
    观察线程的五大状态
            1.NEW  新生状态
            2.RUNNABLE  就绪状态与运行状态
            3.TIMED_WAITING 阻塞状态
            4.TERMINATED 死亡状态
 */
public class ThreadState {

    public static void main(String[] args){
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        Thread.State s = t.getState();  //NEW  新生状态
        System.out.println(s);

        t.start();      //RUNNABLE  就绪状态与运行状态
        s = t.getState();
        System.out.println(s);

        while(s!=Thread.State.TERMINATED){


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s = t.getState();//TIMED_WAITING
            System.out.println(s);
        }


        s = t.getState();   //TERMINATED
        System.out.println(s);

    }

}
