package Homework_2.Question_5;

import sun.rmi.runtime.Log;

import java.util.concurrent.ThreadLocalRandom;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 21:09
 *   @Description :
 *
 */
public class Receiver implements Runnable{

    private Data load;

    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for(String receiveMessage = load.receive();!"End".equals(receiveMessage); receiveMessage = load.receive()){
            System.out.println(receiveMessage);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
