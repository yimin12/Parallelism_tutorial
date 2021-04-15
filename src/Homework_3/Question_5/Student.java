package Homework_3.Question_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 16:35
 *   @Description :
 *
 */
public class Student {

    private static int nextID = 0;
    private String name;
    private Integer id, homework, quiz, midterm, project, final_score;
    private List<Integer> scores;

    public Student() {
        this.id = nextInt();
        this.name = "Student_" + id;
    }

    public Student(Integer homework, Integer quiz, Integer midterm, Integer project, Integer final_score){
        this.id = nextInt();
        this.name = "Student_" + id;
        this.homework = homework;
        this.quiz = quiz;
        this.midterm = midterm;
        this.project = project;
        this.final_score = final_score;
    }

    public void init() throws InterruptedException {
        generateScores();
        this.quiz = 0;
        this.project = 0;
        this.scores = new ArrayList<Integer>();
        this.scores.add(homework);
        this.scores.add(quiz);
        this.scores.add(midterm);
        this.scores.add(project);
        this.scores.add(final_score);
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

    public void generateScores(){
        this.homework = generateScore();
        this.quiz = generateScore();
        this.midterm = generateScore();
        this.project = generateScore();
        this.final_score = generateScore();
    }

    private Integer generateScore(){
        int score = (int)(Math.random()*31 + 70);
        return score;
    }

    private int nextInt(){
        return ++nextID;
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
