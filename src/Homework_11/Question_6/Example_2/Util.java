package Homework_11.Question_6.Example_2;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/14 12:42
 *   @Description :
 *
 */
public class Util {

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static int median(int a, int b, int c) {
        if (a <= b) {
            if (c <= a) {
                return a;
            }
            return b <= c ? b : c;
        }
        if (c <= b) {
            return b;
        }
        return a <= c ? a : c;
    }
}
