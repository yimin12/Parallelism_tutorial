package Homework_4.Question_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 20:09
 *   @Description :
 *
 */
public class StudentThread extends Thread{

    private Student student;
    private Map<Integer, List<Integer>> map; // key : thread id, value : scores
    private final Lock mapLock;
    private static final String path = "src/Homework_4/Question_3/FinalGrades.txt";

    public StudentThread(Lock mapLock, Map<Integer, List<Integer>> map) throws InterruptedException {
        this.map = map;
        this.student = new Student();
        this.mapLock = mapLock;
    }

    @Override
    public void run() {
        try {
            List<Integer> list = student.generateScores();
            mapLock.lock();
            map.put((int)Thread.currentThread().getId(), list);
            mapLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isRunning = true;
        while(isRunning){
            try {
                readGrade();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isRunning = false;
        }
    }

    public static synchronized void readGrade() throws InterruptedException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            StringBuffer sb = new StringBuffer(); // should not use StringBuilder here
            while((line = br.readLine())!=null){
                String formatted = line + " " + " and message is from thread_" + Thread.currentThread().getId();
                System.out.println(formatted);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void init() throws InterruptedException {
        this.student.generateHomeword();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateMidterm();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateFinal();
        TimeUnit.SECONDS.sleep(1);
        List<Integer> scores = this.student.getScores();
        scores.add(this.student.getHomework());
        scores.add(0);
        scores.add(this.student.getMidterm());
        scores.add(0);
        scores.add(this.student.getFinal_score());
        map.put((int)Thread.currentThread().getId(), scores);
    }


}
