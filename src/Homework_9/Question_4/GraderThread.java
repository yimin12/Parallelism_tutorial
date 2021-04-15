package Homework_9.Question_4;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 19:20
 *   @Description :
 *
 */
public class GraderThread extends Thread implements Runnable{

    private final static String path = "src/Homework_9/Question_4/Grades.txt";
    private final static String outputPath = "src/Homework_9/Question_4/outputGrade.txt";
    private Integer homework, quiz, midterm, project, final_score;
    private final Lock lock;

    public GraderThread(Lock lock){
        this.lock = lock;
    }

    public void readAndGrade() throws IOException, InterruptedException {
        this.lock.lock();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            StringBuffer sb = new StringBuffer(); // should not use StringBuilder here
            while((line = br.readLine())!=null){
                sb.append(line).append("\t");
                String[] strings = line.split("\t");
                this.homework = Integer.parseInt(strings[2]);
                this.quiz = Integer.parseInt(strings[3]);
                this.midterm = Integer.parseInt(strings[4]);
                this.project = Integer.parseInt(strings[5]);
                this.final_score = Integer.parseInt(strings[6]);
                String grade = grader();
                sb.append(grade).append("\n");
            }
            writeToFile(sb.toString());
        }
        this.lock.unlock();
    }

    public void writeToFile(String msg) throws IOException {
        File file = new File(outputPath);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(msg);
        bw.close();
    }

    @Override
    public void run() {
        try{
            while(true){
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Grader is running!!!!");
                long start = System.currentTimeMillis();
                readAndGrade();
                long end = System.currentTimeMillis();
                System.out.println("Consuming time for grader writing to outputGrades  " + (end - start));
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
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
}
