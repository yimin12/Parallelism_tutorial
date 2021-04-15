package Homework_6.Question_6;

import Homework_6.Question_4.Sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 19:05
 *   @Description :
 *
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("Configuring 4 threads to execute the task including main thread");
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        int[][] arr = {{9,12,6,14,10,21,13},{3,5,41,16,14,10,21},
                {3,15,41,17,11,10,51}, {3,15,41,17,11,10,51},
                {2,15,35,10,11,12,19},{1,20,33,18,12,13,44}};
        List<List<Integer>> matrix = new ArrayList<>();
        for(int[] i : arr){
            matrix.add(Arrays.stream(i).boxed().collect(Collectors.toList()));
        }
        System.out.println("The original input is following");
        System.out.println(matrix.toString());
        System.out.println("Using the collections sort");
        matrix.parallelStream().forEach(SortedData::collectonSort);
        System.out.println("After collection sorting");
        System.out.println(matrix.toString());
        System.out.println("Using the heap sort");
        matrix.parallelStream().forEach(SortedData::heapSort);
        System.out.println("After collection sorting");
        System.out.println(matrix.toString());

    }
}
