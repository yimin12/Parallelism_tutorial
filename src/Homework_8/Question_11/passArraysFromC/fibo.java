package Homework_8.Question_11.passArraysFromC;

import java.util.Scanner;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25 22:47
 *   @Description :
 *
 */
public class fibo {

   native int[] returnfibo(int n);

    static
    {
        System.loadLibrary("fibo");
    }

    public static void main(String args[])
    {
        Scanner inp = new Scanner(System.in);

        System.out.println(" > Enter n :: ");
        int n = inp.nextInt();

        fibo obj = new fibo();
        int[] Fibo = obj.returnfibo(n);

        System.out.println(" > The first "+n+" fibonacci numbers are :: ");

        for(int i=0;i<n;i++)
            System.out.print(Fibo[i]+",");
    }
}