package Homework_2.Question_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 18:09
 *   @Description :
 *
 */
public class StudentThread extends Thread implements Runnable{

    private Student student; // one student per student thread
    private final static String path = "src/Homework_2/Question_4/Grades.txt.txt";
    private Object lock;
    public StudentThread(Student student, Object lock){
        this.student = student;
        this.lock = lock;
    }

    public void writeToFile(Student student) throws IOException {
        synchronized (lock){
            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            String formatted = "Thread_" + student.getId() + "\t" + student.getFormatted();
            bw.write(formatted + "\n");
            bw.close();
        }
    }

    @Override
    public void run() {
        try{
            while(true){
                this.student.generateScores();
                writeToFile(this.student);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}
