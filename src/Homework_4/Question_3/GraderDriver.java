package Homework_4.Question_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 21:49
 *   @Description :
 *
 */
public class GraderDriver {

    public static volatile Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws InterruptedException {

        map = new HashMap<>();
        Lock lock = new ReentrantLock();
        Thread[] studentThread = new StudentThread[80];
        GraderThread grader = new GraderThread(lock, map);
        for(int i = 0; i < 80; i ++){
            studentThread[i] = new StudentThread( lock, map );
            studentThread[i].start();
        }
        TimeUnit.SECONDS.sleep(1L);
        grader.start();
    }
}
