package Homework_1.Question_7;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 21:33
 *   @Description :
 *
 */
public class Job implements Runnable{

    private static Thread [] jobs = new Thread[4];
    private int threadID;
    private int count;
    public Job(int ID) {
        threadID = ID;
    }
    public void run() {
        for(int i = 0; i < 10; i ++){
            this.count++;
            System.out.println("This is from : " + Thread.currentThread().getName() + " and it is the "
                    + count + " times to show up");
        }
    }
    public static void main(String [] args) {
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new Thread(new Job(i));
            jobs[i].start();
        }
        try {
            for(int i=0; i<jobs.length; i++) {
                jobs[i].join();
            }
        } catch(InterruptedException e) { System.out.println(e); }
    }
}
