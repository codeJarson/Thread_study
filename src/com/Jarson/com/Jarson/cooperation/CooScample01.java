package com.Jarson.com.Jarson.cooperation;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

/**
 * @author Jarson
 * @create 2019-05-28 17:43
 */
/*
    生产者消费者模式：
            分析： 两个对象：生产者 Produter  消费者Customer    ，一个缓冲区（仓库），数据（货品），
                 对应的方法：push（），pop（）
 */

public class CooScample01 {
    public static void main(String[] args){
        SynContainer container = new SynContainer();
                new Produter(container).start();
                new Customer(container).start();

    }
}
//生产者
class Produter extends  Thread{
      SynContainer container;

    public Produter(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //container = new SynContainer();

        //生产
        for (int i = 0; i <100; i++) {
            System.out.println("生产了"+i+"个牛肉丸");
            container.produce(new BeefMeatballs(i));
        }
    }

}
//消费者
class Customer extends  Thread{
    private  SynContainer container;

    public Customer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //container = new SynContainer();错误： 在这创建了一个全新的对象，使得下面的调用不是用的是传进来的container，所以会出现counter一直为0的情况。

        //消费
        for (int i = 0; i <100; i++) {
            BeefMeatballs bm = container.pop();
            System.out.println("消费了第"+bm.id+"号牛肉丸");

        }
    }

}
//缓冲区（容器）
class SynContainer {
    int counter = 0;
    BeefMeatballs[] bms  =   new BeefMeatballs[100];

        //生产
     public  synchronized  void produce(BeefMeatballs bm){
         //控制什么时候不生产？仓库满的时候
         while(counter==bms.length){    //计数器与bms长度一致时
             try {
                 this.wait();    //使得该线程等待，（不生产）
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

        bms[counter] = bm;  //将一个货品放入到容器中
        counter++;
        //System.out.println(counter);
         this.notify();  //有货了，唤醒所有的线程
    }

    //获取
    public synchronized BeefMeatballs pop(){
        //System.out.println(counter);
               //什么时候不消费？
        while(counter==0){ //当中没数据时
            try {
                this.wait();//线程阻塞 生产者通知（notify）消费者解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(counter);
        counter--;//取容器中最后一个元素（货品）。如counter为20，--后，bms【counter】就为最后一个
        this.notifyAll();//并且唤醒所有线程
        return bms[counter];

    }
}
//数据
class BeefMeatballs{
        public int id;//牛肉丸的编号

    public BeefMeatballs(int id) {
        this.id = id;
    }


}