#include <bits/stdc++.h>
using namespace std;

map<string, int> mp;
map<int, string> mp2;
int N, M;
string name, input;
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    int i = 1;
    while (N--){
        cin >> name;
        mp[name] = i; 
        mp2[i] = name;
        i++;
    }
    while (M--){
        cin >> input;
        int key = atoi(input.c_str());
        // 입력이 숫자면
        if (key) cout << mp2.find(key)->second << '\n'; 
        // 입력이 문자열이면
        else cout << mp.find(input)->second << '\n';
    }
    return 0;
}