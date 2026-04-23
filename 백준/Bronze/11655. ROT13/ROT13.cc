#include <bits/stdc++.h>
using namespace std;

string s;
int main(){
    getline(cin, s);
    for (char ch : s){
        if (isupper(ch)) ch = 'A' + (ch -'A' + 13) % 26;
        else if (islower(ch)) ch = 'a' + (ch -'a' + 13) % 26;
        cout << ch;
    }
    return 0;
}