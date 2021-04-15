package Homework_3.Question_5;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 19:09
 *   @Description :
 *
 */
public class GradeDriver {

    public static volatile Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws InterruptedException {

        map = new HashMap<>();
        Object lock = new Object();
        Thread[] studentThreads = new Thread[80];
        GraderThread grade = new GraderThread(lock, map);
        for(int i = 0; i < 80; i ++){
            StudentThread studentThread = new StudentThread(new Student(), lock, map, grade) ;
            studentThreads[i] = studentThread;
            studentThread.start();
        }

        grade.start();

    }
}
