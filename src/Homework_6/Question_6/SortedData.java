package Homework_6.Question_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 15:17
 *   @Description :
 *
 */
public class SortedData{

    private static List<Integer> rows;
    private int rows_id;

    public static synchronized void collectonSort(List<Integer> rows){
        Collections.sort(rows, Collections.reverseOrder());
        // print the data
        System.out.println("The current thread: " + Thread.currentThread().getId() + " : " + rows.toString());
    }

    public static synchronized void heapSort(List<Integer> rows){
        if(rows == null){
            return;
        }
        int n = rows.size();
        for(int i = Math.max(0, (n >> 1) - 1); i >= 0; i --){
            percolateDown(rows, n, i);
        }
        // sort it with O(nlogn)
        for(int i = n - 1; i >= 0; i --){
            swap(rows, 0, i);
            percolateDown(rows, i, 0);
        }
        System.out.println("The current thread: " + Thread.currentThread().getId() + " : " + rows.toString());
    }

    private static void percolateDown(List<Integer> rows, int n, int i){
        while(true){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if(right < n && rows.get(right) > rows.get(largest)) largest = right;
            if(left < n && rows.get(left) > rows.get(largest)) largest = left;
            if(largest != i){
                swap(rows, i, largest);
                i = largest;
            } else break;
        }
    }

    private static void swap(List<Integer> rows, int left, int right){
        int temp = rows.get(left); // temp = array[left]
        rows.set(left, rows.get(right)); // array[left] = right
        rows.set(right, temp); // array[right] = temp;
    }

    public static void main(String[] args) {
        List<Integer> rows = Arrays.asList(1,2);
        swap(rows, 0, 1);
    }
}
