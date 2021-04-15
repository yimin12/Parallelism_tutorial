package Homework_8.Question_13;

import java.util.Scanner;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25 23:38
 *   @Description :
 *
 */
public class reverseThread {


    private static native void setJNIEnv();
    private static native String reversefunc(String word);

    static
    {
        System.loadLibrary("reverseThread");
    }


    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);


        reverseThread obj = new reverseThread();

        System.out.println(" > The reversed string is :: "+obj.reversefunc("WelcomeStudents"));
    }
}
