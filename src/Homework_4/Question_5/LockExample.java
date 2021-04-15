package Homework_4.Question_5;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 23:58
 *   @Description :
 *
 */
public class LockExample {

    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Thread thread[] = new Thread[10];
        for(int i = 0; i < 10; i ++){
            thread[i] = new Thread(new PrintingJob(printerQueue), "Thread" + i);
        }
        for(int i = 0; i < 10; i ++){
            thread[i].start();
        }
    }
}


