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
    int array[2][4] = {{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }};
    int reverse[2][4];
    for(int i = 1; i >= 0; i --){
        for(int j = 3; j >= 0; j --){
            reverse[1-i][3-j] = array[i][j];
        }
    }
    for(int i = 0; i < 2; i ++){
        for(int j = 0; j < 4; j ++){
            cout << reverse[i][j];
            if(j < 3){
              cout << ", ";
            }
        }
        cout << endl;
    }
    return 0;
}