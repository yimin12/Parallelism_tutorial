package Homework_1.Question_2;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2020/9/17 21:29
 *   @Description :
 *
 */
public class TestDriver {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        // step1: create 35 student instances
        for(int i = 0; i < 35; i ++){
            Student student = new Student();
            student.generateSocre();
            students.add(student);
        }
        Thread[] threads = new Thread[students.size()];
        for(int i = 0; i < students.size(); i ++){

            threads[i] = new Thread(students.get(i));
            threads[i].start();
        }
    }
}
