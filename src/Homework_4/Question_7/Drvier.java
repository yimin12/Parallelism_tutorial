package Homework_4.Question_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 23:33
 *   @Description :
 *
 */
public class Drvier {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyHashMap scoresHashMap = new MyHashMap(50);
//        ExecutorService executor = Executors.newFixedThreadPool(51);
//        List<Future> list = new ArrayList<Future>();
        List<Student> students = new ArrayList<>();
        FutureTask[] tasks = new FutureTask[50];
        for(int i = 0; i < 50; i ++){
            students.add(new Student());
        }
        System.out.println("Program start !!!");
        GraderThread grader = new GraderThread(scoresHashMap);
        new Thread(grader).start();
//        executor.execute(grader);
        for(int i = 0; i < 50; i ++){
//            Future<String> s = executor.submit(new StudentThread(students.get(i), scoresHashMap));
//            list.add(s);
            Callable callable = new StudentThread(students.get(i), scoresHashMap);
            tasks[i] = new FutureTask(callable);
            new Thread(tasks[i]).start();
        }
        for(FutureTask f : tasks){
           f.get();
        }
//        executor.shutdown();

    }
}
