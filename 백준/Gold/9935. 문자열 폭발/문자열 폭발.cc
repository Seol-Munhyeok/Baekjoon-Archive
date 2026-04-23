#include <bits/stdc++.h>
using namespace std;

string s, bomb, ret;
stack<char> stk;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> s >> bomb;
    for (char ch : s){
        stk.push(ch);
        if (stk.size() >= bomb.size() && stk.top() == bomb[bomb.size() - 1]){
            string ss = "";
            for (char i : bomb){
                ss += stk.top();
                stk.pop();
            }
            reverse(ss.begin(), ss.end());
            if (bomb != ss){
                for (char i : ss){
                    stk.push(i);
                }
                
            }
        }
    }
    if (stk.size() == 0) cout << "FRULA\n";
    else {
        while (stk.size()){
            ret += stk.top(); stk.pop();
        }
        reverse(ret.begin(), ret.end());
        cout << ret << '\n';
    }
    return 0;
}