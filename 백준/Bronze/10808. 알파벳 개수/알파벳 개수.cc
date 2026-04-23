#include <bits/stdc++.h>
using namespace std;

string str;
int cnt[26];
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> str;
    for (char ch : str){
        cnt[ch - 'a']++;
    }
    for (int i = 0; i < 26; i++) cout << cnt[i] << " ";
    return 0;
}