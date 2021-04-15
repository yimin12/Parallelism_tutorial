#include<jni.h>
#include"Homework_8_Question_11_HelloWorld.h"
#include<stdio.h>

JNIEXPORT void JNICALL Java_Homework_18_Question_111_HelloWorld_cfunction
  (JNIEnv *env, jobject o){
  	printf("\n > C says HelloWorld !\n");
  }

