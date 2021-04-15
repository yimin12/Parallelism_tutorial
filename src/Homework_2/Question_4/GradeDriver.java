package Homework_2.Question_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 19:09
 *   @Description :
 *
 */
public class GradeDriver {

    public static void main(String[] args) throws InterruptedException {
        Thread[] studentThreads = new Thread[50];
        Object lock = new Object();
        //init
        for(int i = 0; i < 50; i ++){
            StudentThread studentThread = new StudentThread(new Student(), lock);
            studentThreads[i] = studentThread;
            studentThreads[i].start();

        }

        TimeUnit.SECONDS.sleep(10);

        Thread grader = new GraderThread(lock);
        grader.start();
    }
}
