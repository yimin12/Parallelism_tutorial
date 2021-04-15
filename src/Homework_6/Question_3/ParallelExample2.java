package Homework_6.Question_3;

import java.util.ArrayList;
import java.util.List;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/4 11:29
 *   @Description :
 *
 */
public class ParallelExample2 {

    public static void main(String[] args) {
        System.out.println("Normal...");
        List<String> alpha = getData();
        alpha.stream().forEach(System.out::println);
        System.out.println("Parallel...");
        List<String> alpha2 = getData();
        alpha2.parallelStream().forEach(System.out::println);
    }

    private static List<String> getData() {
        List<String> alpha = new ArrayList<>();
        int n = 97;  // 97 = a , 122 = z
        while (n <= 122) {
            char c = (char) n;
            alpha.add(String.valueOf(c));
            n++;
        }
        return alpha;
    }
}
