package Homework_4.Question_4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/19 0:18
 *   @Description :
 *
 */
public class Reentrant {

    int level = 0;
    Lock lock = new ReentrantLock();

    public void outer(){
        lock.lock();
        System.out.println("First level start");
        inner();
        System.out.println("First level finish");
        lock.unlock();
    }

    public synchronized void inner(){
        level ++;
        lock.lock();
        try{
            if(level <= 3){
                System.out.println("Second level start");
                inner();
                if(level == 2){
                    System.out.println("This is level 2");
                    TimeUnit.SECONDS.sleep(1);
                }
                System.out.println("This is level 3");
            }  else {
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            level --;
        }
    }
}
