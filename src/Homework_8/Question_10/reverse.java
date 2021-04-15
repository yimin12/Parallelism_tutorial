package Homework_8.Question_10;

/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24 20:42
 *   @Description :
 *
 */
public class reverse {

    public static void main(String[] args) {
        int[][] array = {{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }};
        int rows = array.length;
        int cols = array[0].length;
        int[][] reverse = new int[rows][cols];
        for(int i = rows-1; i >= 0; i--) {
            for(int j = cols-1; j >= 0; j--) {
                reverse[rows-1-i][cols-1-j] = array[i][j];
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(reverse[i][j]);
                if(j < cols-1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
