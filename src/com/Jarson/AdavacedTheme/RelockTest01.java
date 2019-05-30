package com.Jarson.AdavacedTheme;

/**
 * @author Jarson
 * @create 2019-05-29 20:48
 */
/*
    可重入锁   概念：所可以延续下去使用，并且当中的计数器次数++；
 */
public class RelockTest01 {
}
class ReLock {
    private boolean isLocked =false;
    private Thread t = null;
    private  int count = 0; //计数器
    //重入锁
    public synchronized void lock(){
            Thread t2 = Thread.currentThread();
        if(t!=t2 && isLocked){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
                isLocked = true;
                   t = t2;
                count++;
    }
    //释放锁
    public synchronized void unLock() throws InterruptedException {
        while(Thread.currentThread()==t){
            count--;
            if(count==0){
                isLocked = false;
                t = null;
                notifyAll();
            }
        }
    }
}