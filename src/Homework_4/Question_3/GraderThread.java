package Homework_4.Question_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 20:12
 *   @Description :
 *
 */
public class GraderThread extends Thread{

    private Lock mapLock;
    private Map<Integer, List<Integer>> map;
    private static final String path = "src/Homework_4/Question_3/FinalGrades.txt";

    public GraderThread(Lock lock, Map<Integer, List<Integer>>  map){
        this.mapLock = lock;
        this.map = map;
    }

     @Override
    public void run() {
        int count = 0;
        while(count < 80){
            mapLock.lock();
            //int random =(int)(Math.random()*80), index = 0;
            if(map != null && map.size() > 0){
//                if(index == random){
                    for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                        Integer id = entry.getKey();
                        List<Integer> scores = entry.getValue();
                        String finalGrade = grader(scores);
                        String format = "This transcript is from thread_" + id + " And the grade is " + finalGrade;
                        try {
                            writeToFile(format, path);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
//                }
            }
            map.clear();
            mapLock.unlock();
        }
    }

    public synchronized void writeToFile(String format, String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(format + "\n");
        bw.close();
    }


    private String grader(List<Integer> scores){
        double cal = calculateGrade(scores.get(0), scores.get(1), scores.get(2), scores.get(3), scores.get(4));
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
