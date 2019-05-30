package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 11:46
 */
/*
    join（） 可以使线程阻塞，
            并等待其他线程执行完后才能执行本身

 */
public class ThreadJoin03 {


    public static void main(String[] args) throws InterruptedException {

            Thread t =new Thread(()->{
                for (int i = 0; i <60; i++) {
                    System.out.println("I am Lambda"+i);
                }

            });
                    t.start();
        for (int i = 0; i <60; i++) {
            if(i==10){
                t.join(1000);

            }
            System.out.println("I am main"+i);
        }
    }
}
