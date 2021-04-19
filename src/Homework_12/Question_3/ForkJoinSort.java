package Homework_12.Question_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/19 15:20
 *   @Description :
 *
 */
public class ForkJoinSort {

    private final ForkJoinPool pool;

    public ForkJoinSort(int parallelism){
        this.pool = new ForkJoinPool(parallelism);
    }

    public void sort(int[] array){
        ForkJoinTask<Void> job = pool.submit(new FJSort(array, 0, array.length));
        job.join();
    }

    private static class FJSort extends RecursiveAction{

//        private static final long serialVersionUID = -196522408291343951L;
        private final int[] array;
        private final int low, high;
        private static final int THRESHOLD = 3;

        public FJSort(int[] array, int low, int high){
            this.array = array;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if(high - low <= THRESHOLD){
                Arrays.sort(array, low, high);
            } else {
                int mid = low + ((high - low) >> 1);
                invokeAll(new FJSort(array, low, mid), new FJSort(array, mid, high));
                merge(mid);
            }
        }

        private void merge(int middle) {
            if (array[middle - 1] < array[middle]) {
                return; // the arrays are already correctly sorted, so we can skip the merge
            }
            int[] copy = new int[high - low];
            System.arraycopy(array, low, copy, 0, copy.length);
            int copyLow = 0;
            int copyHigh = high - low;
            int copyMiddle = middle - low;
            for (int i = low, p = copyLow, q = copyMiddle; i < high; i++) {
                if (q >= copyHigh || (p < copyMiddle && copy[p] < copy[q]) ) {
                    array[i] = copy[p++];
                } else {
                    array[i] = copy[q++];
                }
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinSort fs = new ForkJoinSort(10);
        int[][] arr =  { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21},    { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
                { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42},    { 2, 15, 35, 10, 11, 12, 19}, { 1, 20, 33, 18, 12, 13, 44} };
        for(int[] a : arr){
            fs.sort(a);
        }
        List<List<Integer>> matrix = new ArrayList<>();
        for(int[] i : arr){
            matrix.add(Arrays.stream(i).boxed().collect(Collectors.toList()));
        }
        System.out.println(matrix.toString());
    }

}
