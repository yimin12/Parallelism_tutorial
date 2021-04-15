package Homework_6.Question_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 13:32
 *   @Description :
 *
 */
public class Sorted {

    public static void main(String[] args) {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        int[][] arr = {{9,12,6,14,10,21,13}, {3,5,41,16,14,10,21},
                {3,15,41,17,11,10,51}, {3,15,41,17,11,10,51},
                {4,15,35,17,11,12,55}, {2,16,31,18,12,11,42},
                {2,15,35,10,11,12,19}, {1,20,33,18,12,13,44}};
        List<List<Integer>> matrix = new ArrayList<>();
        for(int[] i : arr){
            matrix.add(Arrays.stream(i).boxed().collect(Collectors.toList()));
        }
        matrix.parallelStream().forEach(Sorted::sort);
        System.out.println(matrix.toString());
    }

    public static void sort(List<Integer> array){
        synchronized (array){
            Collections.sort(array);
            System.out.println(array.toString());
        }
    }
}
