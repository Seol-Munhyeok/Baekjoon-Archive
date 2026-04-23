#include <bits/stdc++.h>
using namespace std;

string s;
map<char, int> mp;
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> s;
    for (int i = 0; i < 26; i++)
        mp['a' + i] = 0;
    for (char ch : s) mp[ch] += 1;
    for (auto it : mp) cout << it.second << ' ';
    return 0;
}