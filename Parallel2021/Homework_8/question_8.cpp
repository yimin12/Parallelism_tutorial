/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24
 *   @Description :
 *
 */
#include <iostream>
using namespace std;

void swap(int *a, int * b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main(){

    int a = 1, b = 2;
    swap(a, b);
    cout << "a : " << a << " b : " << b << endl;

    return 0;
}