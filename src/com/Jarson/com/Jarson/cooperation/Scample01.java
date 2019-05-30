package com.Jarson.com.Jarson.cooperation;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author Jarson
 * @create 2019-05-29 13:50
 */

/*分析：对象：参与者actor，竞选者Campaiger，方法：投票（poll）
 *
 */
public class Scample01 {
    public static void main(String[] args){

        //面向对象
        ArrayList<Campaiger> list = new ArrayList<>();
            list.add(new Campaiger(1,"黄梓毅"));
            list.add(new Campaiger(2,"黄琳渊"));
            list.add(new Campaiger(3,"罗卓能"));
        Campaiger[] campaiger = new Campaiger[100];
            //campaiger[0] = [1,"黄梓毅"];
        SynPoll synPoll = new SynPoll(list);
        actor actor = new actor(synPoll);
         actor  actor1  =   new actor(synPoll);
         actor  actor2  =   new actor(synPoll);
         actor  actor3  =   new actor(synPoll);
        for (int i = 0; i < 2; i++) {
            new Thread(actor,"潘伟杰").start();
           new Thread(actor1,"杨俊豪").start();
           new Thread(actor2,"刘嘉威").start();
           new Thread(actor3,"陈家榜").start();
        }
    }

}
//参与者
class actor implements Runnable {
    SynPoll synPoll;

    public actor(SynPoll synPoll) {
        this.synPoll = synPoll;
    }

    @Override
    public void run() {
        System.out.println("请做出你的选择！"+Thread.currentThread().getName());
        synPoll.poll();
    }
}
class SynPoll {
    Campaiger[] campaiger = new Campaiger[100];
    List<Campaiger> list;

    public SynPoll(Campaiger[] campaiger) {
        this.campaiger = campaiger;
    }

    public SynPoll(List<Campaiger> list) {
        this.list = list;
    }

    //投票        //加锁
    public synchronized void poll(){
        Random random = new Random();
        int i = random.nextInt(3)+1;    //[1,4)

        if(i==campaiger[0].getId() ){
            System.out.println(Thread.currentThread().getName()+"选择"+i+"号黄梓毅");
            System.out.println("");

        }else if (i==campaiger[1].getId()){
            System.out.println(Thread.currentThread().getName()+"选择"+i+"号黄琳渊");
            System.out.println("");
        }else{
            System.out.println(Thread.currentThread().getName()+"选择"+i+"号罗卓能");
            System.out.println("");
        }

    }
}
//竞选者
class Campaiger  {
    private  int id  ;
    private String cName;

    public Campaiger(int id,String cName) {
        this.id = id;
        this.cName = cName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
