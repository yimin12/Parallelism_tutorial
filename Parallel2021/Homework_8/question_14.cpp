/*
 *   @Author : Yimin Huang
 *   @Contact : hymlaucs@gmail.com
 *   @Date : 2021/3/24
 *   @Description :
 *
 */
#include <iostream>
using namespace std;

struct movies_t {
    string title;
    int year;
};


struct friends_t {
    string name;
    string email;
    movies_t favorite_movie;
} charlie, maria;


int main() {
    friends_t *pfriends = &charlie;
    pfriends->name = "charlie";
    pfriends->email = "charlie@gmail.com";
    struct movies_t m1;
    m1.title = "TheShy";
    m1.year = 2018;
    pfriends->favorite_movie = m1;
    cout << pfriends->name << endl;
    cout << pfriends->email << endl;
    cout << "year : " << pfriends->favorite_movie.year << " title: " << pfriends->favorite_movie.title << endl;
    delete pfriends;
    return 0;
}
