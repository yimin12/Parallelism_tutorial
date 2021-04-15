package Homework_4.Question_7;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 21:05
 *   @Description :
 *
 */
public class Result {

    private Integer id;
    private Double averageScore;
    private String final_grade;

    public Result(Integer id, Double averageScore, String final_grade) {
        this.id = id;
        this.averageScore = averageScore;
        this.final_grade = final_grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public String getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(String final_grade) {
        this.final_grade = final_grade;
    }

    @Override
    public String toString() {
        return "Result{" + "id : " + id +
                ", final_grade='" + final_grade + '\'' +
                '}';
    }
}
