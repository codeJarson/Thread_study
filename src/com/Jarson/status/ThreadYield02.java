package com.Jarson.status;

/**
 * @author Jarson
 * @create 2019-05-26 11:46
 */
/*
    Yield 可以使线程暂停，注： 该方法可以使线程重新回到就绪状态，等待cpu调度
 */
public class ThreadYield02 {


    public static void main(String[] args){

            new Thread(()->{
                for (int i = 0; i <60; i++) {
                    System.out.println("I am Lambda"+i);
                }

            }).start();
        for (int i = 0; i <60; i++) {
            if(i%10==0){
                Thread.yield();//当i能被10取余时，暂停了main线程，回到就绪，等待cpu调度
                System.out.println("I am 'main'"+i);
            }
            System.out.println("I am main"+i);
        }
    }
}
