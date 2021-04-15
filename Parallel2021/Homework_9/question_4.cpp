/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/31
 *   @Description :
 *
 */
#include <pthread.h>
#include <iostream>
#include <string>
#include <fstream>
#include <cstdlib>
#include <map>
#include <algorithm>
#include <iterator>
#include <vector>
#include <sstream>
#include <ctime>

using namespace std;
using std::ofstream;

int next_id = 1;
void* studentThread(void*);
void* graderThread(void*);

//Using a map to save key-value pairs(name-grade)
map<string, string> gradeMap;
pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER; // create explicit lock
pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER; // create explicit lock


string calculate(vector<string> & cont){
    int Homework = stoi(cont[4]);
    int Midterm = stoi(cont[6]);
    int Final = stoi(cont[8]);
    int Quiz = stoi(cont[10]);
    int Project = stoi(cont[12]);
    double grade = (Homework * 0.25 + Midterm * 0.15 + Final * 0.2 + Quiz * 0.25 + Project * 0.15);
    if(grade > 90.0){
        return "A";
    } else if(grade > 80.0){
        return "B";
    } else if(grade > 70.0){
        return "C";
    } else if(grade > 60.0){
        return "D";
    } else {
        return "F";
    }
}

template <class Container>
void split1(const string& str, Container& cont)
{
    istringstream iss(str);
    copy(istream_iterator<string>(iss),
         istream_iterator<string>(),
         back_inserter(cont));
}

void grader(string line){
    ofstream outdata;
    outdata.open("F:\\Materials\\MyCode\\cLion_workSpace\\Parallel2021\\Homework_9\\finalGrades.txt", ios::app);
    vector<string> words;
    split1(line, words);
    string res = calculate(words);
    string student_id = words[2];
    outdata << "Student id : " << student_id << " Final grade : " << res << endl;
}

void* studentThread(void*)
{
    pthread_mutex_lock(&mutex1);
    string name = "Student " + to_string(next_id);
    next_id++;
    pthread_mutex_unlock(&mutex1);

    while(1){

        int homework = rand() % 31 + 70;
//        sleep(1);
        int quiz = rand() % 31 + 70;
//        sleep(1);
        int midterm = rand() % 31 + 70;
//        sleep(1);
        int project = rand() % 31 + 70;
//        sleep(1);
        int final = rand() % 31 + 70;
//        sleep(1);

//        printf("name: %s || homework: %d mideterm: %d final: %d quiz: %d project: %d\n", name.c_str(), homework, midterm, final, quiz, project);
        const clock_t begin_time = clock( );
        pthread_mutex_lock(&mutex1);
        ofstream outdata;
        outdata.open("F:/Materials/MyCode/cLion_workSpace/Parallel2021/Homework_9/Grades.txt", ios::app); // opens the file
        outdata << "name: " << name << " Homework: " << homework << " Midterm: " << midterm << " Final: " << final << " Quiz: " << quiz << " Project: " << project << endl;
        outdata.close();
        pthread_mutex_unlock(&mutex1);
        float seconds = float(clock( ) - begin_time);
        cout << "total time consuming is " << seconds << endl;
    }
}

void *graderThread(void*)
{
    while(1){
//        sleep(3);
        pthread_mutex_lock(&mutex1);
        string line;
        ifstream file("F:/Materials/MyCode/cLion_workSpace/Parallel2021/Homework_9/Grades.txt");
        if(file.is_open()){
            while(getline(file, line)){
                grader(line);
            }
            file.close();
        }
        pthread_mutex_unlock(&mutex1);
    }
}

int main(){

    // 100 student threads
    pthread_t threads[100];
    for(int i = 0; i < 100; i++) {
        pthread_create(&(threads[i]), NULL, studentThread, NULL);
    }
    // one grader thread
    pthread_t gradeThread;
    int retGrade = pthread_create(&gradeThread, NULL, graderThread, NULL);
    if(!retGrade){
        pthread_join(gradeThread, NULL);
    }
    for(int i = 0; i < 100; i ++){
        pthread_join(threads[i], NULL);
    }



    return 0;
}
