package Homework_8.Question_8;

import java.util.Arrays;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24 21:43
 *   @Description :
 *
 */
public class SWAP {

    private static void swap(int left, int right, int[] array){
        while(left < right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        swap(0, array.length - 1, array);
        Arrays.stream(array).forEach(System.out::print);
    }
}
