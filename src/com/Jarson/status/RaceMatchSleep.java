package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-25 15:00
 */
/*
    利用多线程模拟龟兔赛跑
            思路：
                写好结构
                1.实现Runnable接口+重写run（）
                2.创建实现类对象（一份资源）+代理类对象（可以多个代理）

      加上线程中的sleep方法
      使得线程调用时发生延时
       可以看到线程体中的错误
 */
public class RaceMatchSleep implements Runnable{
    private String winner;//赢家
    @Override
    public void run() {
        int step;
        for ( step = 1; step <=100 ; step++) {
            if(Thread.currentThread().getName().equals("rabbit")&&step%10==0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"-->"+step);
            boolean flag  =gameOver(step);
            if(flag){
                break;
            }
        }




    }
      private  boolean gameOver(int step){
        if(winner!=null){
            return true;
        }else{
            if(step==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner="+winner);
                return true;
            }
        }
        return false;
      }
    public static void main(String[] args){
        //实现类对象
        RaceMatchSleep raceMatch = new RaceMatchSleep();
        //代理类对象（可以多个代理）
        new Thread(raceMatch,"totorcie").start();
        new Thread(raceMatch,"rabbit").start();

    }
}
