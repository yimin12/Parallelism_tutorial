package Homework_8.Question_11.parseIntegerFromC;

import java.util.Scanner;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25 21:58
 *   @Description :
 *
 */
public class factorial {

    native int fact(int num);

    static {
        System.loadLibrary("forfactorial");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" > Please enter a number :: ");
        int num = in.nextInt();
        factorial f = new factorial();
        System.out.println(" > The factorial of " + num + " is " + f.fact(num));
    }
}
