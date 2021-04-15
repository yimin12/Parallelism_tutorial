package Homework_1.Question_9;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 23:11
 *   @Description :
 *
 */
public class Test {

    public static void main(String args[]){
        Table obj1 = new Table();
        MyThread1 t1=new MyThread1(obj1);
        MyThread2 t2=new MyThread2(obj1);
        t1.start();
        t2.start();
    }
}
