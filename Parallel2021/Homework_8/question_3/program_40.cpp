/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/25
 *   @Description :
 *
 */
#include <math.h>
#include <stdio.h>
int convertFromDecimalToBinary(long long n);
long long convertFromBinaryToDecimal(int n);

int main(){
    long long n;
    printf("Enter a binary number: ");
    scanf("%lld", &n);
    printf("%lld in binary = %d in decimal", n, convertFromDecimalToBinary(n));

    int m;
    printf("Enter a decimal number: ");
    scanf("%d", &m);
    printf("%d in decimal = %lld in binary", m, convertFromBinaryToDecimal(m));
    return 0;
}

int convertFromDecimalToBinary(long long n){
    int dec = 0, i = 0, rem;
    while(n != 0){
        rem = n % 10;
        n /= 10;
        dec += rem * pow(2, i);
        ++i;
    }
    return dec;
}

long long convertFromBinaryToDecimal(int n){
    long long bin = 0;
    int rem, i = 1, step = 1;
    while(n != 0){
        rem = n % 2;
        printf("Step %d: %d/2, Remainder = %d, Quotient = %d\n", step++, n, rem, n / 2);
        n /= 2;
        bin += rem * i;
        i *= 10;
    }
    return bin;
}
