package Homework_4.Question_7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/20 17:37
 *   @Description :
 *
 */
public class MyHashMap {

    private final int LIMIT;;
    private static LinkedList<Result> QUEUE = new LinkedList<Result>();
    private static HashMap<Integer, Double> scoresMap = new HashMap<>();
    private static HashMap<Integer,String> finalGrades = new HashMap<>();
    //private Lock lock = new ReentrantLock();

    public MyHashMap(int LIMIT){
        this.LIMIT = LIMIT;
    }

    public void offer(Result data) throws InterruptedException {
        synchronized(this){
            while(QUEUE.size() >= LIMIT){
//                System.out.println("The queue is full...");
                this.wait();

            }
            QUEUE.addLast(data);
            scoresMap.put((int) Thread.currentThread().getId(), data.getAverageScore());
            this.notifyAll();
        }

    }

    public Result take() throws InterruptedException {
        synchronized(this){
            while(QUEUE.isEmpty()){
//                System.out.println("The queue is empty");
                this.wait();
            }
            this.notifyAll();
            return QUEUE.removeFirst();
        }
    }

    public void updateGrades(Result result){
        finalGrades.put(result.getId(), result.getFinal_grade());

    }

    public String readGrades(Integer id){
        synchronized(this){
            String grade = finalGrades.get(id);
            return grade;
        }
    }

    public HashMap<Integer, Double> getScoresMap() {
        return scoresMap;
    }

    public HashMap<Integer, String> getFinalGrades() {
        return finalGrades;
    }
}
