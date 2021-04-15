package Homework_6.Question_8;



/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 14:55
 *   @Description :
 *
 */
public class SimulatedCAS {

    private int value;

    public SimulatedCAS(int val){
        this.value = val;
    }

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;
        if(oldValue == expectedValue){
            value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        return (expectedValue == compareAndSwap(expectedValue,newValue));
    }
}
