package Homework_11.Question_3;

import java.util.Arrays;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/13 22:48
 *   @Description :
 *
 */
public class QuickSort_3 {

    public static void swap(int[] array, int left, int right){
        int temp = array[left] ^ array[right];
        array[left] ^= temp;
        array[right] ^= temp;
    }

    public static int[] quickSort(int[] array){
        if(array == null) return array;
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int left, int right){
        if(left >= right) return ;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    public static int partition(int[] array, int left, int right){
        int pivotIndex = left + ((right - left) >> 1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while(leftBound <= rightBound){
            if(array[leftBound] < pivot){
                leftBound ++;
            } else if(array[rightBound] >= pivot){
                rightBound --;
            } else {
                swap(array, leftBound ++ , rightBound --);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    public static int[] generateRandomArray(int maxValue) {
        int[] arr = new int[(int) ((100000 + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int[] res = quickSort(array);
        Arrays.stream(res).forEach(a -> System.out.print(a + " "));
        System.out.println("---------------------------------");

        int testTime = 500;
        long start = System.currentTimeMillis();
        for(int i = 0; i < testTime; i ++){
            int[] arr = generateRandomArray(10000);
            quickSort(arr);
        }
        long end = System.currentTimeMillis();
        System.out.println("total time consuming is " + (end - start));
    }
}
