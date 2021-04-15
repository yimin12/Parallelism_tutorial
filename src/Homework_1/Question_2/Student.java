package Homework_1.Question_2;

import java.io.*;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 19:13
 *   @Description :
 *
 */
public class Student implements Runnable{

    private static final String path = "src/Homework_1/Question_2/Grades.txt.txt.txt";

    private static int nextID = 0;
    private String name;
    private Integer id, homework_score, midterm_score, final_score, project_score, quiz_score;
    private String finalGrade;

    private Object lock; // object monitor

    // basic constructor
    public Student(){
        this.id = nextInt();
        this.name = "Thread_" + nextID;
    }

    public Student(Object lock){
        this.id = nextInt();
        this.name = "Thread_" + nextID;
        this.lock = lock;
    }

    public void generateSocre(){
        this.homework_score = (int)(Math.random()*41 + 60);
        this.midterm_score = (int)(Math.random()*41 + 60);
        this.final_score = (int)(Math.random()*41 + 60);
        this.quiz_score = (int)(Math.random()*41 + 60);
        this.project_score = (int)(Math.random()*41 + 60);
        this.finalGrade = calculateGrade();
    }

    public Student(Integer homework_score, Integer midterm_score, Integer final_score, Integer project_score, Integer quiz_score){
        this.id = nextInt();
        this.name = "Thread_" + nextID;
        this.homework_score = homework_score;
        this.midterm_score = midterm_score;
        this.final_score = final_score;
        this.project_score = project_score;
        this.quiz_score = quiz_score;
    }

    // required function
    public String calculateGrade(){
        double cal = calculateScore(this.homework_score, this.midterm_score, this.final_score, this.project_score, this.quiz_score);
        if(cal > 90.0){
            return "A";
        } else if(cal > 80.0){
            return "B";
        } else if(cal > 70.0){
            return "C";
        } else if(cal > 60.0){
            return "D";
        }
        return "F";
    }

    private double calculateScore(Integer homework_score, Integer midterm_score, Integer final_score, Integer project_score, Integer quiz_score){
        if(homework_score == null || midterm_score == null || final_score == null || project_score == null || quiz_score == null){
            new Exception("No result for current student");
        }
        return (homework_score * 0.2 + midterm_score * 0.25 + final_score * 0.2 + quiz_score * 0.2 + project_score * 0.15);
    }

    @Override
    public String toString() {
        return "name= " + "Student_" + id +
                " ThreadId='" + name + '\'' +
                ", nextId=" + id +
                ", homework_score=" + homework_score +
                ", midterm_score=" + midterm_score +
                ", final_score=" + final_score +
                ", project_score=" + project_score +
                ", quiz_score=" + quiz_score +
                " and his/her final grade are " + finalGrade;
    }

    private int nextInt() {
        return ++nextID;
    }

    public Integer getHomework_score() {
        return homework_score;
    }

    public void setHomework_score(Integer homework_score) {
        this.homework_score = homework_score;
    }

    public Integer getMidterm_score() {
        return midterm_score;
    }

    public void setMidterm_score(Integer midterm_score) {
        this.midterm_score = midterm_score;
    }

    public Integer getFinal_score() {
        return final_score;
    }

    public void setFinal_score(Integer final_score) {
        this.final_score = final_score;
    }

    // print the name to grade file
    public static synchronized void writeToFile(Student student) throws IOException{
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        String formatted = student.toString();
        bw.write(formatted + "\n");
        bw.close();
    }

    @Override
    public void run() {
        try{
            while(true){
                generateSocre();
                writeToFile(this);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}
