package com.Jarson.syn;

import java.util.List;

/**
 * @author Jarson
 * @create 2019-05-27 20:36
 */
/*
    影院购座位票案例：
        分析：
            1.两个对象：影院cinema，顾客customer  ，一个方法：bookTicket（）
        思路：
            1.创建两个类Cinema，Customer 实现Runnable，  一个方法bookTicket（）在Cinema类中
            2.我们需要知道Cinema的剩余位置availableSeats，名字cName    顾客的名字name，购票数int seats
            3.在run（）中，加入同步块（synchronized），synchronized（this）当中的this指的是Cinema对象，锁住的对象的地址是不可变的
               若当中是可变的对象，如（cinema.availableSeats），则会锁不住，出现线程不安全。
 */
public class ThreadScample {
    public static void main(String[] args){
        JarsonCinema cinema = new JarsonCinema("JarsonCinema",20);
        Customer c1 = new Customer(20,"Jarson",cinema);
        new Thread(c1).start();

        Customer c2 = new Customer(1,"zzz",cinema);
               new Thread(c2).start();
    }
}
class JarsonCinema {
    private  String name ;
    public   int availableSeats;  //可用座位

    public JarsonCinema(String name , int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
    }
         //购票的方法
        public boolean bookTicket(int seats){
            if(seats>availableSeats){   //失败
                return false;

            }else{  //成功
                availableSeats -=seats; //成功后位置的剩余量
                return true;
            }

    }
}
class Customer implements Runnable{
   private JarsonCinema cinema;
    private int seats;
    private String name;

    public Customer(int seats, String name, JarsonCinema cinema) {
        this.seats = seats;
        this.name = name;
        this.cinema = cinema;
    }


    @Override
    public void run() {
        if(this.seats<=0){
            System.out.println("你还未选择位置！");
           return;
        }
        synchronized (this){
            boolean flag =cinema.bookTicket(this.seats);

            if(flag==true){
                System.out.println(this.name+"购票成功，电影院剩余票数："+cinema.availableSeats);
            }else{
                System.out.println(this.name+"购票失败，电影院剩余票数："+cinema.availableSeats);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}