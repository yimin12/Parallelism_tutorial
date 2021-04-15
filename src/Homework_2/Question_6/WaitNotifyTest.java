package Homework_2.Question_6;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 21:33
 *   @Description :
 *
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        Message msg = new Message("process it");

        Waiter waiter1= new Waiter(msg);
        new Thread(waiter1,"waiter1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();

        Waiter waiter3= new Waiter(msg);
        new Thread(waiter3,"waiter3").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }
}
