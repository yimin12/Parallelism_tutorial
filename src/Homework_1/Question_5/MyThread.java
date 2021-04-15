package Homework_1.Question_5;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 21:27
 *   @Description :
 *
 */
public class MyThread implements Runnable{

    Input ip;
    Object lock;

    public MyThread(Input ip, Object lock){
        this.ip = ip;
        this.lock = lock;
    }

    @Override
    public void run() {
        int index = -1;
        while((index=ip.getIndex())!=-1){
            synchronized(lock) {
                System.out.println(
                        Thread.currentThread().getName());

                ip.print(index);
            }
        }
    }
}
