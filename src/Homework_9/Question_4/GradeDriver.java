package Homework_9.Question_4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31 23:38
 *   @Description :
 *
 */
public class GradeDriver {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread[] studentThread = new StudentThread[100];
        GraderThread graderThread = new GraderThread(lock);
        for(int i = 0; i < studentThread.length; i ++){
            studentThread[i] = new StudentThread(lock);
            studentThread[i].start();
        }
        graderThread.start();
        graderThread.join();
    }
}
