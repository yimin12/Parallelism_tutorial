package Homework_2.Question_4;

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

    public Student(){
        this.id = nextInt();
        this.name = "Student_" + id;
        this.homework = this.quiz = this.midterm = this.project = this.final_score = 0;
        this.generateScores();
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
}
