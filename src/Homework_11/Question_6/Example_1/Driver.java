package Homework_11.Question_6.Example_1;

import Homework_11.Question_3.QuickSort_3;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/14 12:39
 *   @Description :
 *
 */
public class Driver {

    private static final int SIZE = 100_000;
    private static final int FROM = 100;
    private static final int TO = SIZE - 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int proc = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(proc);

        long seed = System.nanoTime();
        Random random = new Random(seed);
        int[] array1 = getRandomArray(SIZE, 0, 1_000_000_000, random);
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();

        System.out.println("Seed: " + seed);
        long startTime = System.nanoTime();
        QuickSort.forkJoinQuicksort(pool, array1);
        long endTime = System.nanoTime();

        System.out.printf("QuickSort.ForkJoinQuickSort in %.2f milliseconds.\n",
                (endTime - startTime) / 1e6);

        startTime = System.nanoTime();
        QuickSort.latchQuicksort(executor, array2);
        endTime = System.nanoTime();

        System.out.printf("ParallelIntQuicksort.sort in %.2f milliseconds.\n",
                (endTime - startTime) / 1e6);

        startTime = System.nanoTime();
        QuickSort_3.quickSort(array3);
        endTime = System.nanoTime();

        System.out.printf("QuickSort from question 3 in %.2f milliseconds.\n",
                (endTime - startTime) / 1e6);

        System.out.println("Arrays are equal: " +
                (Arrays.equals(array1, array2) &&
                        Arrays.equals(array2, array3)));
    }

    public static int[] getRandomArray(int size,
                                       int minimum,
                                       int maximum,
                                       Random random) {
        int[] array = new int[size];

        for (int i = 0; i < size; ++i) {
            array[i] = random.nextInt(maximum - minimum + 1) + minimum;
        }

        return array;
    }
}
