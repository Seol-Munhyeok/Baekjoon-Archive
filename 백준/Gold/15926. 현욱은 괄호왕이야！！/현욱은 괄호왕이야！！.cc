#include <bits/stdc++.h>
using namespace std;

int n, cnt, ret;
string str;
stack<int> s;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n;
    cin >> str;
    s.push(-1);
    for (int i = 0; i < n; i++){
        if (str[i] == '(') s.push(i);
        if (str[i] == ')'){
            s.pop();
            if (s.size()) {
                ret = max(ret, i - s.top());
            }
            else s.push(i);
        }
    }
    cout << ret << '\n';
    return 0;
}