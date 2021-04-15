package Homework_4.Question_6;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/2/18 23:44
 *   @Description :
 *
 */
public class Driver {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode();
        TreeNode child = new TreeNode();
        new Thread(()->{
            parent.addChild(child);
        }).start();

        new Thread(()->{
            child.setParentOnly(parent);
        }).start();
    }
}
