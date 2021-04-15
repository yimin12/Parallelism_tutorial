package Homework_2.Question_5;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/3 21:03
 *   @Description :
 *
 */
public class Data {

    private String packet;

    private boolean transfer = true;

    public synchronized void send(String packet){
        while(!transfer){
            try{
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = false;
        this.packet = packet;
        notify();
    }

    public synchronized String receive(){
        while(transfer){
            try{
                wait();
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        transfer = true;
        notifyAll();
        return packet;
    }
}
