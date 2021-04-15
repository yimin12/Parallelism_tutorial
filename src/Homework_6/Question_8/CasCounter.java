package Homework_6.Question_8;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 14:52
 *   @Description :
 *
 */
public class CasCounter {

    private SimulatedCAS value ;

    public CasCounter(){
        this.value = new SimulatedCAS(0);
    }

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }
}
