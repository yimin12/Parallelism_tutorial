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
}*top = NULL;

void push(int, char*, char*, char*);
void pop();
void display();

int main()
{
    system("cls");
    push(1, "Jack", "Irwan", "Software Engineering");
    push(2, "Billy", "Mckao", "Requirement Engineering");
    push(3, "Nat", "Mcfaden", "Multivariate Calculus");
    push(4, "Steven", "Shwimmer", "Software Architecture");
    push(5, "Ruby", "jason", "Relational DBMS");
    push(6, "Mark", "Dyne", "PHP development");
    push(7, "Philip", "namdaf", "Microsoft Dot Net Platform");
    push(8, "Erik", "Bawn", "HTML & Scripting");
    push(9, "Ricky", "ben", "Data Communications");
    push(10, "Van", "Miecky", "Computer Networks");
    display();
    pop();
    pop();
    pop();
    pop();
    pop();
    pop();
    pop();
    pop();
    pop();
    pop();
    display();
    return 0;
}
void push(int value, char* firstName, char* lastName, char* course)
{
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->id = value;
    newNode->firstName = firstName;
    cout << newNode->firstName << endl;
    newNode->lastName = lastName;
    newNode->course = course;
    if(top == NULL)
        newNode->next = NULL;
    else
        newNode->next = top;
    top = newNode;
    printf("\nInsertion is Success!!!\n");
}
void pop()
{
    if(top == NULL)
        printf("\nStack is Empty!!!\n");
    else{
        struct Node *temp = top;
        cout << "Delete node with id: " << temp->id << endl;
        top = temp->next;
        free(temp);
    }
}
void display()
{
    if(top == NULL)
        printf("\nStack is Empty!!!\n");
    else{
        struct Node *temp = top;
        while(temp->next != NULL){
            cout << temp->id << " : " << temp->firstName << " " << temp->lastName << " with course " << temp->course << " ---> ";
            temp = temp->next;
        }
        cout << temp->id << " : " << temp->firstName << " " << temp->lastName << " with course " << temp->course << " ---> NULL";
    }
}