/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31
 *   @Description :
 *
 */
#include <iostream>
#include <stdio.h>
#include <string>
using namespace std;

struct Node
{
    int id;
    char* firstName;
    char* lastName;
    char* course;
    struct Node *next;
}*front = NULL,*rear = NULL;

void insert(int, char*, char*, char*);
void deleteNode();
void display();

int main(){

    system("cls");
    insert(1, "Jack", "Irwan", "Software Engineering");
    insert(2, "Billy", "Mckao", "Requirement Engineering");
    insert(3, "Nat", "Mcfaden", "Multivariate Calculus");
    insert(4, "Steven", "Shwimmer", "Software Architecture");
    insert(5, "Ruby", "jason", "Relational DBMS");
    insert(6, "Mark", "Dyne", "PHP development");
    insert(7, "Philip", "namdaf", "Microsoft Dot Net Platform");
    insert(8, "Erik", "Bawn", "HTML & Scripting");
    insert(9, "Ricky", "ben", "Data Communications");
    insert(10, "Van", "Miecky", "Computer Networks");
    display();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    deleteNode();
    display();
    return 0;
}

void insert(int value, char* firstName, char* lastName, char* course)
{
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->id = value;
    newNode->firstName = firstName;
    newNode->lastName = lastName;
    newNode->course = course;
    newNode -> next = NULL;
    if(front == NULL)
        front = rear = newNode;
    else{
        rear -> next = newNode;
        rear = newNode;
    }
    printf("\nInsertion is Success!!!\n");
}

void deleteNode()
{
    if(front == NULL)
        printf("\nQueue is Empty!!!\n");
    else{
        struct Node *temp = front;
        front = front -> next;
        printf("\nDeleted element: %d\n", temp->id);
        free(temp);
    }
}

void display()
{
    if(front == NULL)
        printf("\nQueue is Empty!!!\n");
    else{
        struct Node *temp = front;
        while(temp->next != NULL){
            cout << temp->id << " : " << temp->firstName << " " << temp->lastName << " with course " << temp->course << " ---> ";
            temp = temp -> next;
        }
        cout << temp->id << " : " << temp->firstName << " " << temp->lastName << " with course " << temp->course << " ---> NULL";
    }
}