#include <bits/stdc++.h>
using namespace std;

int N, cnt = 0;
string str;
stack<char> stk;

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> N;
    while (N--){
        cin >> str;
        for (char ch : str) {
            if (!stk.empty() && stk.top() == ch)
                stk.pop();
            else stk.push(ch);
        }
        if (stk.empty()) cnt++;
        while (!stk.empty()) stk.pop();
    }
    cout << cnt << '\n';
    return 0;
}