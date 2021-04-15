package Homework_4.Question_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 19:11
 *   @Description :
 *
 */
public class Student {

    private static volatile int nextID = 0;
    private String name;
    private Integer id, homework, quiz, midterm, project, final_score;
    private List<Integer> scores;
    private final static Lock classLock = new ReentrantLock();

    public Student(){
        classLock.lock();
        this.id = getNextID();
        this.name = "Student_" + id;
        // init here
        this.id = this.homework = this.quiz = this.midterm = this.project = this.final_score = 0;// all scores are set to 0 initially
        generateHomeword();
        generateMidterm();
        generateFinal();
        this.scores = new ArrayList<Integer>();
        scores.add(this.homework);
        scores.add(this.quiz);
        scores.add(this.midterm);
        scores.add(this.project);
        scores.add(this.final_score);
        classLock.unlock();
    }

    public Student(Integer homework, Integer quiz, Integer midterm, Integer project, Integer final_score){
        this.id = getNextID();
        this.name = "Student_" + id;
        this.homework = homework;
        this.quiz = quiz;
        this.midterm = midterm;
        this.project = project;
        this.final_score = final_score;
    }

    public void generateHomeword(){
        this.homework = generateScore();
    }

    public void generateQuiz(){
        this.quiz = generateScore();
    }

    public void generateMidterm(){
        this.midterm = generateScore();
    }

    public void generateFinal(){
        this.final_score = generateScore();
    }

    public void generateProject(){
        this.project = generateScore();
    }

    public String getFormatted(){
        return this.name + "\t" + this.homework + "\t" + this.quiz  + "\t" + this.midterm  + "\t" + this.project + "\t" + this.final_score + "\t";
    }

    public List<Integer> generateScores() throws InterruptedException {
        this.homework = generateScore();
        TimeUnit.SECONDS.sleep(1);
        this.quiz = generateScore();
        TimeUnit.SECONDS.sleep(1);
        this.midterm = generateScore();
        TimeUnit.SECONDS.sleep(1);
        this.project = generateScore();
        TimeUnit.SECONDS.sleep(1);
        this.final_score = generateScore();
        toList();
        return scores;
    }

    private void toList() {
        scores.set(0, this.homework);
        scores.set(1, this.quiz);
        scores.set(2, this.midterm);
        scores.set(3, this.project);
        scores.set(4, this.final_score);
    }

    private Integer generateScore(){
        int score = (int)(Math.random()*31 + 70);
        return score;
    }

    private int getNextID(){
        this.nextID ++;
        return this.nextID;
    }

    public Integer getHomework() {
        return homework;
    }

    public Integer getQuiz() {
        return quiz;
    }

    public Integer getMidterm() {
        return midterm;
    }

    public Integer getProject() {
        return project;
    }

    public Integer getFinal_score() {
        return final_score;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", homework=" + homework +
                ", quiz=" + quiz +
                ", midterm=" + midterm +
                ", project=" + project +
                ", final_score=" + final_score +
                '}';
    }

    public List<Integer> getScores() {
        return scores;
    }
}
