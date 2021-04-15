package Homework_6.Question_8;

import Homework_6.Question_5.JavaAtomic2;

import java.util.concurrent.atomic.AtomicInteger;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 14:58
 *   @Description :
 *
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }

    private static class ProcessingThread implements Runnable {
        private CasCounter count = new CasCounter();
        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                processSomething(i);
                count.increment();
            }
        }
        public int getCount() {
            return this.count.getValue();
        }
        private void processSomething(int i) {
            // processing some job
            try {
                Thread.sleep(i * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
