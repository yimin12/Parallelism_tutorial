package Homework_3.Question_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 19:20
 *   @Description :
 *
 */
public class GraderThread extends Thread implements Runnable{

    private final static String outputPath = "src/Homework_3/Question_5/FinalGrades.txt";
    private Integer homework, quiz, midterm, project, final_score;
    private Object lock;
    private static Map<Integer, List<Integer>> map;
    private static volatile boolean flag = false;

    public GraderThread(Object lock, Map<Integer, List<Integer>> map){
        this.lock = lock;
        this.map = map;
    }

    private String grader(){
        double cal = calculateGrade(this.homework, this.quiz, this.midterm, this.project, this.final_score);
        if(cal > 90){
            return "A";
        } else if(cal > 80){
            return "B";
        } else if(cal > 70){
            return "C";
        } else if(cal > 60){
            return "D";
        }
        return "F";
    }

    private double calculateGrade(Integer homework, Integer quiz, Integer midterm, Integer project, Integer final_score){
        if(homework == null || quiz == null || midterm == null || project == null || final_score == null){
            new Exception("No result for current student");
        }
        return (homework * 0.25 + 0.25 * quiz + 0.15 * midterm + 0.15 * project + 0.2 * final_score);
    }

    public void readAndGrade() throws IOException, InterruptedException {
        synchronized (lock) {
            String msg = "";
            List<Integer> keys = new ArrayList(map.keySet());
            List<List<Integer>> values = new ArrayList(map.values());
            for(int k = 0; k < 3; k ++){
                int i = (int)(Math.random() * (keys.size()));
                List<Integer> score = values.get(i);
                this.homework = score.get(0);
                this.quiz = score.get(1);
                this.midterm = score.get(2);
                this.project = score.get(3);
                this.final_score = score.get(4);
                String grade = grader();
                msg = "This transcript is from thread_" + keys.get(i) + " And the grade is " + grade + "\n";
            }
            writeToFile(msg);
            this.flag = true;
            lock.notifyAll();
        }
    }

    public void writeToFile(String msg) throws IOException {
        File file = new File(outputPath);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(msg);
        bw.close();
    }

    public static boolean getFlag() {
        return flag;
    }

    @Override
    public void run() {
        try{
            while(true){
                TimeUnit.SECONDS.sleep(7);
                System.out.println("Grader is running!!!!");
                readAndGrade();
                break;
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }

    }
}
