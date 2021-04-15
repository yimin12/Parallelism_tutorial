package Homework_4.Question_3;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 21:05
 *   @Description :
 *
 */
public class Result {

    private Integer id, homework, quiz, midterm, project, final_score;
    String final_grade;

    public Result(Integer id, Integer homework, Integer quiz, Integer midterm, Integer project, Integer final_score, String final_grade) {
        this.id = id;
        this.homework = homework;
        this.quiz = quiz;
        this.midterm = midterm;
        this.project = project;
        this.final_score = final_score;
        this.final_grade = final_grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHomework() {
        return homework;
    }

    public void setHomework(Integer homework) {
        this.homework = homework;
    }

    public Integer getQuiz() {
        return quiz;
    }

    public void setQuiz(Integer quiz) {
        this.quiz = quiz;
    }

    public Integer getMidterm() {
        return midterm;
    }

    public void setMidterm(Integer midterm) {
        this.midterm = midterm;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getFinal_score() {
        return final_score;
    }

    public void setFinal_score(Integer final_score) {
        this.final_score = final_score;
    }

    public String getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(String final_grade) {
        this.final_grade = final_grade;
    }

    @Override
    public String toString() {
        return "Result{" +
                "homework=" + homework +
                ", quiz=" + quiz +
                ", midterm=" + midterm +
                ", project=" + project +
                ", final_score=" + final_score +
                ", final_grade='" + final_grade + '\'' +
                '}';
    }
}
