#include<jni.h>
#include"Homework_8_Question_11_passStringFromC_reverse.h"
#include<stdio.h>

JNIEXPORT jstring JNICALL Java_Homework_18_Question_111_passStringFromC_reverse_reversefunc
  (JNIEnv *env, jobject jobj, jstring original)
  {
    const char *org;
    char *rev;
    org = (*env)->GetStringUTFChars(env, original, NULL);

    int i;
    int size = (*env)->GetStringUTFLength(env, original);
    for(int i = 0; i < size; i ++){
        rev[i] = org[size - 1 -i];
    }
    rev[size] = '\0';
    return (*env)->NewStringUTF(env, rev);
  }