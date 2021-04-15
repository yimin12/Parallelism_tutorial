/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24
 *   @Description :
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;
int count = 0; // race condition
void *print_message_function( void *ptr );
void * sum(void *pVoid);

int main()
{
    pthread_t thread1, thread2, thread3, thread4;
    const char *message1 = "Thread 1";
    const char *message2 = "Thread 2";
    int  iret1, iret2, iter3, iter4;

    /* Create independent threads each of which will execute function */

    iret1 = pthread_create( &thread1, NULL, print_message_function, (void*) message1);
    if(iret1)
    {
        fprintf(stderr,"Error - pthread_create() return code: %d\n",iret1);
        exit(EXIT_FAILURE);
    }

    iret2 = pthread_create( &thread2, NULL, print_message_function, (void*) message2);
    if(iret2)
    {
        fprintf(stderr,"Error - pthread_create() return code: %d\n",iret2);
        exit(EXIT_FAILURE);
    }

    printf("pthread_create() for thread 1 returns: %d\n",iret1);
    printf("pthread_create() for thread 2 returns: %d\n",iret2);

    if( (iter3=pthread_create(&thread3, NULL, sum, NULL)) ){
        printf("Thread creation failed: %d\n", iter3);
    }
    if( (iter4=pthread_create(&thread4, NULL, sum, NULL)) ){
        printf("Thread creation failed: %d\n", iter4);
    }
    /* Wait till threads are complete before main continues. Unless we  */
    /* wait we run the risk of executing an exit which will terminate   */
    /* the process and all threads before the threads have completed.   */

    pthread_join( thread1, NULL);
    pthread_join( thread2, NULL);
    pthread_join( thread3, NULL);
    pthread_join( thread4, NULL);

    exit(EXIT_SUCCESS);
}

void *print_message_function( void *ptr )
{
    pthread_mutex_lock( &mutex1 );
    char *message;
    message = (char *) ptr;
    printf("%s \n", message);
    pthread_mutex_unlock( &mutex1 );
}

void * sum(void *)
{
    pthread_mutex_lock( &mutex2 );
    int times = 1000000000;
    while(times --){
        count ++;
    }
    printf("Counter value: %d\n",count);
    pthread_mutex_unlock( &mutex2 );

}