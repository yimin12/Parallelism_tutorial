package Homework_3.Question_7;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/11 0:28
 *   @Description :
 *
 */
public class Test{

    public static int calculate (int i, int j, int k) {
        int a = i * j * k + k * i + 20 ;
        return a;
    }

    public static void main(String[] args) {
        Runnable test = new Runnable() {
            @Override
            public void run() {
                int a = calculate(3, 4, 5);
                System.out.println("resutl : " + a);
            }
        };
        Thread thread = new Thread(test);
        thread.start();
    }
}
