package Homework_8.Question_11.passStringsFromC;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25 22:10
 *   @Description :
 *
 */
public class daysofweek {

    native String[] returndays();

    static
    {
        System.loadLibrary("daysofweek");
    }

    static public void main(String args[])
    {

        daysofweek obj = new daysofweek();
        String[] days = obj.returndays();

        System.out.println(" > The days of the week are :: ");
        for(String name: days)
            System.out.println(name);
    }
}
