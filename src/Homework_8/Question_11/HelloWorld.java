package Homework_8.Question_11;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24 20:35
 *   @Description :
 *
 */
public class HelloWorld {

    native void cfunction();

    static {
        System.loadLibrary("helloworld");
    }

    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.class.path"));
        HelloWorld obj = new HelloWorld();
        obj.cfunction(); // invoke the native function
    }
}
