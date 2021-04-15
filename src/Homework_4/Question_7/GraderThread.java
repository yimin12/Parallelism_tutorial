package Homework_4.Question_7;


import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 22:45
 *   @Description :
 *
 */
public class GraderThread implements Runnable {

    private MyHashMap scoresHashMap;

    public GraderThread(MyHashMap scoresHashMap){
       this.scoresHashMap = scoresHashMap;
    }

    private String calculate(Double res){
        if(res > 90){
            return "A";
        } else if(res > 80){
            return "B";
        } else if(res > 70){
            return "C";
        } else if(res > 60){
            return "D";
        }
        return "F";
    }


    @Override
    public void run() {
       try {
           TimeUnit.SECONDS.sleep(1);
           while(true) {
               Result result = scoresHashMap.take();
               String finalGrade = calculate(result.getAverageScore());
               result.setFinal_grade(finalGrade);
               System.out.println("result" + result.toString());
               scoresHashMap.updateGrades(result);
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

    }
}
