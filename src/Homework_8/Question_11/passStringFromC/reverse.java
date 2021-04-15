package Homework_8.Question_11.passStringFromC;

import java.util.Scanner;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25 23:32
 *   @Description :
 *
 */
public class reverse {
    native String reversefunc(String word);

    static {
        System.loadLibrary("reverse");
    }

    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        System.out.println(" > Enter a string :: ");
        String word = inp.nextLine();
        reverse obj = new reverse();
        System.out.println(" > The reversed string is :: " + obj.reversefunc(word));
    }
}
