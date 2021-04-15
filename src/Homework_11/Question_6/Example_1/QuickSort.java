package Homework_11.Question_6.Example_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/14 12:01
 *   @Description :
 *
 */
public class QuickSort {

    /**
     * Convenience method.  Invokes a LatchQuickSortTask in the provided pool, blocking until done.
     * @param pool executes sorting tasks
     * @param arr array to sort
     * @return sorted array
     * @throws InterruptedException thrown when the current thread is interrupted
     */
    public static int[] latchQuicksort(ExecutorService pool, int[] arr) throws InterruptedException {
        LatchQuicksortTask task = new LatchQuicksortTask(arr, pool);
        pool.execute(task);
        task.waitUntilSorted();
        return arr;
    }

    /**
     * Convenience method.  Invokes a ForkJoinQuickSortTask in the provided pool, blocking until done.
     * @param pool executes sorting tasks
     * @param arr array to sort
     * @return sorted array
     */
    public static int[] forkJoinQuicksort(ForkJoinPool pool, int[] arr) {
        pool.invoke(new ForkJoinQuicksortTask(arr));
        return arr;
    }

    /**
     * Example invocation:
     * <pre>
     * {@code
     *  public static int[] sequentialQuicksort(int[] a, int left, int right) {
    while (left < right) {
    int pivotIndex = partition(a, left, right);
    sequentialQuicksort(a, left, pivotIndex);
    left = pivotIndex + 1;
    }
    return a;
    }
     * }
     * </pre>
     * @param arr array to partition
     * @param left lower bound for partition
     * @param right upper bound for partition (inclusive)
     * @return pivot index - assert(a[i] < a[j]) for all i where {left <= i <= pivot}
     * and all j where {j > pivot}
     * @see ForkJoinQuicksortTask
     * @see LatchQuicksortTask
     */
    public static int parititon(int[] arr, int left, int right){
        // choose middle value of range for our pivot
        int pivotValue = arr[middleIndex(left, right)];
        --left;
        ++right;
        while(true){
            do ++left;
            while(arr[left] < pivotValue);
            do --right;
            while(arr[right] > pivotValue);

            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                return right;
            }
        }

    }

    // calculates middle index without integer overflow
    private static int middleIndex(int left, int right) {
        return left + (right - left) / 2;
    }
}
