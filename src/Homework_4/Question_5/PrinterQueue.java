package Homework_4.Question_5;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 23:53
 *   @Description :
 *
 */
public class PrinterQueue {

    private final Lock queueLock = new ReentrantLock();

    public synchronized void printJob(Object document){
//        queueLock.lock();
        try{
            Long duration = (long)(Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000) + " seconds :: Time - " + new Date());
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
//            queueLock.unlock();
        }
    }
}
