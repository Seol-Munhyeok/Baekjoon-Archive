#include <bits/stdc++.h>
using namespace std;
string str, ret, tmp = "";
map<char, int> mp;

bool check(string str){
    // 팰린드롬을 만들 수 있으면 true 반환
    int cnt = 0;  // 각 문자 개수가 홀수인 것이 2개 이상있으면 팰린드롬 만들 수 없음 
     for (auto it : mp) {
        if (it.second % 2 == 1) cnt++;
        if (cnt >= 2) return false;
    }
    return true;
}

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> str;
    for (char ch : str) mp[ch]++;
    if (!check(str)){
        cout << "I'm Sorry Hansoo" << '\n';
        exit(0);
    }
    char center;  // 미할당 시, NULL '\0'으로 초기화
    for (auto it : mp){
        if (it.second % 2 == 1) center = it.first;
        char ch = it.first; int cnt = it.second / 2;
        while (cnt--) tmp += ch;
    }
    ret = tmp;
    reverse(tmp.begin(), tmp.end());
    if (center != '\0') ret += center;  // '\0' 또는 NULL도 가능
    ret += tmp;
    cout << ret << '\n';
    return 0;
}