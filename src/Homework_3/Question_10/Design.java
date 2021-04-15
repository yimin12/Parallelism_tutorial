package Homework_3.Question_10;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/12 15:43
 *   @Description :
 *
 */
public class Design {

    // each of the student class contains 20 bytes
    static class Student1{
        // Assume the object header contains 8 bytes
        String name = "YiminHuang"; // 10 bytes
        int age = 25; // 2 bytes
        public Student1(){}
    }

    public static void main(String[] args) {
        Student1[] students = new Student1[20];
        for(int i = 0; i < 20; i ++){
            students[i] = new Student1();
        }
        // unreference
        for(int i = 0; i < 10; i ++){
            students[i+5] = null;
        }
        System.gc();
    }
}
