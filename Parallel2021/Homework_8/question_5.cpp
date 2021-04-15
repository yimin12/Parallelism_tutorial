/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24
 *   @Description :
 *
 */
#include <iostream>
using namespace std;

int main(){

    // create int variable x with value 5
    int x = 5;
    // a: declare int pointer variable ptr1
    int *ptr1;
    // b: assign a valid address to ptr1
    ptr1 = &x;
    // c: print x, &x, ptr1, *ptr1
    cout << x << " " << &x << " " << ptr1 << " " << *ptr1 << endl;
    // d: declare int pointer to ptr2
    int *ptr2;
    // e: assign ptr1 to ptr2
    ptr2 = ptr1;
    // f: print x, &x, ptr1, *ptr1, ptr2, *ptr2
    cout << x << " " << &x << " " << ptr1 << " " << *ptr1 << " " << ptr2 << " " << *ptr2 << endl;
    // g: assign *ptr1 = 8
    *ptr1 = 8;
    // h:  print x, &x, ptr1, *ptr1, ptr2, *ptr2
    cout << x << " " << &x << " " << ptr1 << " " << *ptr1 << " " << ptr2 << " " << *ptr2 << endl;
    // i: explain
    // j: assign *ptr2=14
    *ptr2 = 14;
    // k:  print x, &x, ptr1, *ptr1, ptr2, *ptr2
    cout << x << " " << &x << " " << ptr1 << " " << *ptr1 << " " << ptr2 << " " << *ptr2 << endl;
    // l: explain
    // m: declare int array arr = {4,12,8,6}
    int arr[4] = {4, 12, 8, 6};
    // n: assign *ptr1 to array arr
    ptr1 = arr;
    // p: increment ptr1 four time, at each iteration, print ptr1, *ptr, &arr, arr[i], ptr2, *ptr2
    for(int i = 0; i < 4; i ++){
        cout << ptr1 + i << " " << &arr << " " << arr[i] << " " << ptr2 << " " << *ptr2 << endl;
    }
    // explain:
    return 0;
}