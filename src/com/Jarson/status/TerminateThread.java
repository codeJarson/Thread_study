package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-25 20:50
 */
/*
    中止线程的方式：
            1.线程执行完毕
            2.外部干涉 加入标识符
                思路：
                    1.定义一个boolean类型的变量，当该变量为false时，则终止线程
 */
public class TerminateThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        long i=0;

        //线程体
        while (flag) {

            System.out.println("wryyyyyyyyyyy*"+i++);
        }

    }

    public void terminate() {
        this.flag = false;

    }

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread();
        new Thread(tt).start();

        for (int i = 0; i < 99; i++) {
               if (i == 88) {
               tt.terminate();
                System.out.println("线程终止");
           }
           System.out.println("main"+i++);
      }
    }
}
