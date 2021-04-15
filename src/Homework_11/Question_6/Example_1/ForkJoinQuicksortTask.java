package Homework_11.Question_6.Example_1;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

import static Homework_11.Question_3.QuickSort_3.partition;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/14 12:30
 *   @Description :
 *
 */
public class ForkJoinQuicksortTask extends RecursiveAction {

    private static final int SERIAL_THRESHOLD = 0x1000;

    private final int[] arr;
    private final int left;
    private final int right;

    public ForkJoinQuicksortTask(int[] arr){
        this(arr, 0, arr.length - 1);
    }

    public ForkJoinQuicksortTask(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if(serialThresholdMet()){
            Arrays.sort(arr, left, right + 1);
        } else {
            int pivotIndex = partition(arr, left, right);
            ForkJoinTask t1 = null;
            if(left < pivotIndex) {
                t1 = new ForkJoinQuicksortTask(arr, left, pivotIndex).fork();
            }
            if(pivotIndex + 1 < right){
                new ForkJoinQuicksortTask(arr, pivotIndex + 1, right).fork();
            }
            if(t1 != null){
                t1.join();
            }
        }
    }

    private boolean serialThresholdMet() {
        return right - left < SERIAL_THRESHOLD;
    }
}
