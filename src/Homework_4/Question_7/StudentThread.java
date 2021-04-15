package Homework_4.Question_7;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 22:08
 *   @Description :
 *
 */
public class StudentThread implements Callable<String>{

    private Student student;
    private MyHashMap scoresHashMap;

    public StudentThread(Student student, MyHashMap scoresHashMap){
        this.student = student;
        this.scoresHashMap = scoresHashMap;
    }

    private Double calculateAverage(Student student){
        Integer sum = 0;
        sum += student.getHomework();
        sum += student.getMidterm();
        sum += student.getQuiz();
        sum += student.getProject();
        sum += student.getFinal_score();
        return (double)(sum / 5);
    }

    private String getStudentGrade(){
        synchronized(scoresHashMap){
            return scoresHashMap.readGrades((int) Thread.currentThread().getId());
        }
    }

    @Override
    public String call() {
        String grade = null;
        try {
            this.student.generateScores();
            Double res = calculateAverage(student);
            Result generateScore = new Result((int) Thread.currentThread().getId(), res, null);
            scoresHashMap.offer(generateScore);
            TimeUnit.SECONDS.sleep(3);
            grade = getStudentGrade();
            System.out.println("This is from Student_" + Thread.currentThread().getId() + " and the final grade is " + grade);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return grade;
    }
}
