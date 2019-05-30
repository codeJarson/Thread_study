package com.Jarson.thread;

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
 */
public class RaceMatch implements Runnable{
    private String winner;//赢家
    @Override
    public void run() {
        int step;
        for ( step = 1; step <=101 ; step++) {
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
        RaceMatch raceMatch = new RaceMatch();
        //代理类对象（可以多个代理）
        new Thread(raceMatch,"totorcie").start();
        new Thread(raceMatch,"rabbit").start();

    }
}
