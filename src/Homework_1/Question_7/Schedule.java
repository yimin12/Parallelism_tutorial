package Homework_1.Question_7;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/1/28 21:36
 *   @Description :
 *
 */
public class Schedule implements Runnable{

    private static Thread [] jobs = new Thread[4];
    private int threadID;
    private int count;
    public Schedule(int ID) {
        threadID = ID;
    }
    public void run() {
        for(;;){
            this.count++;
            System.out.println("This is from : " + Thread.currentThread().getName() + " and it is the "
                    + count + " times to show up");
        }
    }

    private static void setPriority(int priority){
        Thread.currentThread().setPriority(priority);
    }

    public static void  main(String [] args) {
        int nextThread = 0;
        setPriority(Thread.MAX_PRIORITY);
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new Thread(new Job(i));
            jobs[i].setPriority(Thread.MIN_PRIORITY);
            jobs[i].start();
        }
        try {
            for(;;) {
                jobs[nextThread].setPriority(Thread.NORM_PRIORITY);
                Thread.sleep(1000);
                jobs[nextThread].setPriority(Thread.MIN_PRIORITY);
                nextThread = (nextThread + 1) % jobs.length;
            }
        } catch(InterruptedException e) { System.out.println(e); }
    }
}
