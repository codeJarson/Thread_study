package com.Jarson.syn;

import java.util.ArrayList;
import java.util.Iterator;
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
      升级该线程案例，将当中Cinema的票数升级成座位（集合List<Integer>）  ,顾客所选的座位也用容器表示List<Integer>
 */
public class LevelUpScample02 {
    public static void main(String[] args){
        List<Integer> availbleSeats = new ArrayList<>();
        availbleSeats.add(2);
        availbleSeats.add(4);
        availbleSeats.add(6);
        availbleSeats.add(8);
        availbleSeats.add(10);
        JarsonsCinema cinema = new JarsonsCinema("JarsonCinema",availbleSeats);

        //第一个顾客

        ArrayList<Integer> seats = new ArrayList<>();
        seats.add(2);   //所选位置
        seats.add(4);
        seats.add(6);

        JarsonsCustomer c1 = new JarsonsCustomer(seats,"Jarson",cinema);
        new Thread(c1).start();

        //第二个顾客

        ArrayList<Integer> seatss = new ArrayList<>();
        seatss.add(2);   //所选位置
        seatss.add(4);
        seatss.add(7);
        JarsonsCustomer c2 = new JarsonsCustomer(seatss,"zzz",cinema);
          new Thread(c2).start();
    }
}

class JarsonsCinema {
     public int result = 0;
    private  String name ;
    public List<Integer> availableSeats;  //可用座位

    public JarsonsCinema(String name , List<Integer> availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
    }
    //购票的方法
    public boolean bookTicket(List<Integer> seats){
        ArrayList<Integer> copyed = new ArrayList<>();

        copyed.addAll(availableSeats);  //copy集合已得到可用座位集合中的值

        //求差集
        copyed.removeAll(seats);   //假设seats中的座位{2,4,6}，而copyed中的座位{2,4,8,10}，求差集后 copyed集合中的元素变为{8,10}（把相同的元素干掉）。

        //做判断
        if(availableSeats.size()-copyed.size()!=seats.size()){  //失败

            return false;
        }else{  //成功
            //减少过后的剩余量

             result =  availableSeats.size();
            result -= seats.size();
            availableSeats = copyed;
            return true;
        }
    }
}

class JarsonsCustomer implements Runnable{
    private JarsonsCinema cinema;
    private List<Integer> seats;
    private String name;

    public JarsonsCustomer(List<Integer> seats, String name, JarsonsCinema cinema) {
        this.seats = seats;
        this.name = name;
        this.cinema = cinema;
    }


    @Override
    public void run() {
        if(this.seats.isEmpty()){
            System.out.println("你还未选择位置！");
            return;
        }
        synchronized (this){
            boolean flag =cinema.bookTicket(seats);
         /*   Integer seat = null;
            for (int i = 0; i <seats.size(); i++) {
                seat = seats.get(i);
                //System.out.println(seat);测试查看是否有值
            }
             System.out.println(seat);
          */

            /*Iterator<Integer> iterator = cinema.availableSeats.iterator();
            Integer next  = null;
            ArrayList<Integer> nextList = new ArrayList<>();

            while(iterator.hasNext()){
                 next = iterator.next();
                //System.out.println(next);
                nextList.add(next);
            }
             */
            if(flag==true){
                System.out.println(this.name+"购票成功，你所购的位置:"+seats+"，电影院所剩位置："+cinema.availableSeats+"电影院剩余票数："+cinema.result);
            }else{
                System.out.println(this.name+"购票失败，你所购的位置:"+seats+"，电影院所剩位置："+cinema.availableSeats+"电影院剩余票数："+cinema.result);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}