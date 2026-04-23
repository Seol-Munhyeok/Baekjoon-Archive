#include <bits/stdc++.h>
using namespace std;

int n, d[200001], ret, cnt;
string s;
stack<int> stk;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n >> s;
    for (int i = 0; i < n; i++){
        if (s[i] == '(') stk.push(i);
        // 바른 괄호문자열이면 d에 1을 할당한다.
        else if (stk.size()){
            d[i] = d[stk.top()] = 1;
            stk.pop();
        }
    }
    // 가장 긴 1의 길이를 구한다.
    for (int i = 0; i < n; i++){
        if (d[i]){
            cnt++;
            ret = max(ret, cnt);
        }
        else cnt = 0;
    }
    cout << ret << '\n';
    return 0;
}