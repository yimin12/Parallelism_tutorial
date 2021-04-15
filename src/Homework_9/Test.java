package Homework_9;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31 15:40
 *   @Description :
 *
 */
public class Test<E> {

    private final E[] items;

    public Test(){
        this.items =(E[]) new Object[10];
    }

    public E[] getItems() {
        return items;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Object[] res = test.getItems();
        res[2] = 1;

    }
}
