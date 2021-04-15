#include<jni.h>
#include"Homework_8_Question_11_parseIntegerFromC_factorial.h"
#include<stdio.h>

JNIEXPORT jint JNICALL Java_Homework_18_Question_111_parseIntegerFromC_factorial_fact
  (JNIEnv *env, jobject jobj, jint num){

    jint result = 1;
    while(num)
    {
        result *= num;
        num--;
    }
    return result;

  }
