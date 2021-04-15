#include<jni.h>
#include"Homework_8_Question_13_reverseThread.h"
#include<stdio.h>
#include<pthread.h>

JavaVM *javaVM=NULL;
jobject job=NULL;
jstring jstr = NULL;
char *result = NULL;

void *reverse(void *p);


// set the environment
JNIEXPORT void JNICALL Java_Homework_18_Question_113_reverseThread_setJNIEnv
  (JNIEnv *env, jclass clazz)
  {
    (*env)->GetJavaVM(env, &javaVM);
    job = (*env)->NewGlobalRef(env, job);
  }

/*
 * Class:     Homework_8_Question_13_reverseThread
 * Method:    reversefunc
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_Homework_18_Question_113_reverseThread_reversefunc
  (JNIEnv *env, jclass clazz, jstring original)
  {
      pthread_t t1;
      jstr = (jstring)((*env)->NewGlobalRef(env, (jobject) original));
      pthread_create(&t1,NULL,reverse, NULL);
      pthread_join( t1, NULL);
      return (*env)->NewStringUTF(env, result);
  }

 void *reverse(void *p)
  {
    JNIEnv *env;
    jint rs = (*javaVM)->AttachCurrentThread(javaVM,(void **)&env, NULL);
    const char *org;
    char *rev;
    org = (*env)->GetStringUTFChars(env,jstr,NULL);
    int i;
    int size = (*env)->GetStringUTFLength(env,jstr);
    for(i=0;i<size;i++)
       rev[i]=org[size-i-1];
    rev[size]='\0';
    for(int i = 0; i < size; i ++){
        printf("%s", rev + i);
    }
    result = rev;
    (*javaVM)->DetachCurrentThread(javaVM);
  }
