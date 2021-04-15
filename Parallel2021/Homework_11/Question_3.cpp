/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/4/13
 *   @Description :
 *
 */
#include<bits/stdc++.h>
using namespace std;

void swap(int *a, int *b){
    int temp = *a ^ *b;
    *a ^= temp;
    *b ^= temp;
}

int partition(int arr[], int left, int right){
    int mid = left + (right - left)/2;
    int pivot = arr[mid];
    swap(arr[mid], arr[right]);
    int leftBound = left;
    int rightBound = right - 1;
    while(leftBound <= rightBound){
        if(arr[leftBound] < pivot){
            leftBound ++;
        } else if(arr[rightBound] >= pivot){
            rightBound --;
        } else {
            swap(arr[leftBound ++], arr[rightBound --]);
        }
    }
    swap(arr[leftBound], arr[right]);
    return leftBound;
}

void quickSort(int arr[], int left, int right){
    if(left >= right) return;
    int pivot = partition(arr, left, right);
    quickSort(arr, left, pivot - 1);
    quickSort(arr, pivot + 1, right);
}

void printArray(int* arr, int size)
{
    int i;
    for (i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}


int main(){

    int arr[7] = {38, 27, 43, 3, 9, 82, 10};
    int n = sizeof(arr)/sizeof(arr[0]);
    quickSort(arr, 0, n - 1);
    cout << " Sorted array : " << endl;
    printArray(arr, n);

    const clock_t begin_time = clock( );
    int randArray[100000];
    for(int times = 0; times < 500; times ++){
        for(int i = 0; i < 100000; i ++){
            randArray[i] = rand() % 10000;
        }
        quickSort(randArray, 0, 100000 - 1);
    }
    float seconds = float(clock( ) - begin_time);
    cout << "total time consuming is " << seconds << endl;

    return 0;
}
