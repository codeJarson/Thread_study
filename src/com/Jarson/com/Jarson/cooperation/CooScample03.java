package com.Jarson.com.Jarson.cooperation;

/**
 * @author Jarson
 * @create 2019-05-28 21:09
 */
/*
    并发协作——方式二：信号灯法
    案例：看直播
        分析：
            1.对象：TV（当中的方法有：onlyVoice（），watch（）），watcher，player
            2.加入标志符boolean flag
 */
public class CooScample03 {
    public static void main(String[] args){
        DouYu douYu = new DouYu();
                    new Player(douYu).start();
                    new Watcher(douYu).start();

    }
}
//表演者
class Player extends Thread{
    DouYu douYu;

    public Player(DouYu douYu) {
        this.douYu = douYu;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
                douYu.watch();
        }
    }
}
//观看者
class Watcher extends Thread{
    DouYu douYu;

    public Watcher(DouYu douYu) {
        this.douYu = douYu;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            douYu.onlyVoice("你真猛！");
        }
    }
}
//直播平台
class DouYu {
    String voice;
    //信号灯
    boolean flag = true;
    public synchronized  void onlyVoice(String voice){

        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("只能听到声音："+voice);
        this.notifyAll();
        this.flag = !this.flag ;
    }
    public synchronized void watch(){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        this.flag = !this.flag;
        System.out.println("音画同步，开始表演");
    }
}