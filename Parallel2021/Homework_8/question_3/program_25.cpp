/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25
 *   @Description :
 *
 */
#include <stdio.h>
int main(){
    int n, rev = 0, remainder;
    printf("Enter an integer: ");
    scanf("%d", &n);
    while(n != 0){
        remainder = n % 10;
        rev = rev * 10 + remainder;
        n /= 10;
    }
    printf("Reversed number = %d", rev);
    return 0;
}
