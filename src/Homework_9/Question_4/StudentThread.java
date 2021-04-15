package Homework_9.Question_4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31 23:19
 *   @Description :
 *
 */
public class StudentThread extends Thread{

    private Student student;
    private final static String path = "src/Homework_9/Question_4/Grades.txt";
    private final Lock lock;

    public StudentThread(Lock lock){
        this.lock = lock;
        this.student = new Student();
    }

    @Override
    public void run() {
        try {
            while(true){
                generateGrade();
                long start = System.currentTimeMillis();
                writeToFile(this.student);
                long end = System.currentTimeMillis();
                System.out.println("Consuming time for student writing to Grades  " + (end - start));
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Student student) throws IOException {
        this.lock.lock();
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        String formatted = "Thread_" + Thread.currentThread().getId() + "\t" + student.getFormatted();
        bw.write(formatted + "\n");
        bw.close();
        this.lock.unlock();
    }

    public void generateGrade() throws InterruptedException {
        this.student.generateHomeword();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateMidterm();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateFinal();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateProject();
        TimeUnit.SECONDS.sleep(1);
        this.student.generateQuiz();
        TimeUnit.SECONDS.sleep(1);
    }


}
