#include<jni.h>
#include"Homework_8_Question_11_passArraysFromC_fibo.h"
#include<stdio.h>

JNIEXPORT jintArray JNICALL Java_Homework_18_Question_111_passArraysFromC_fibo_returnfibo
  (JNIEnv *env, jobject jobj, jint n)
  {
    jintArray fiboarray  = (*env)->NewIntArray(env,n);

    int first=0;
    int second=1;
    int next;
    int i;
    jint fibo[n];

    for(i=0;i<n;i++)
    {
          if(i<=1)
            next = i;
          else
          {
            next = first + second;
            first = second;
            second = next;
          }

          fibo[i] = next;
    }

    (*env)->SetIntArrayRegion(env,fiboarray,0,n,fibo);

  return fiboarray;
  }