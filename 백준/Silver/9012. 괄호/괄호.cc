#include <bits/stdc++.h>
using namespace std;

int N;
string s;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    while (N--){
        stack<char> stk;
        cin >> s;
        for (char ch : s) {
            if (ch == ')'){
                if (stk.size() && stk.top() == '(') stk.pop();
                else stk.push(ch);
            }
            else stk.push(ch);
        }
        if (stk.size()) cout << "NO" << '\n';
        else cout << "YES" << '\n';
    }
    return 0;
}