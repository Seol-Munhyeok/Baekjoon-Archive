#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9 + 4, MAX = 1000004;
int N, lis[MAX], len, num;
pair<int, int> ans[MAX];
stack<int> stk;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    fill(lis, lis + MAX, INF);
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> num;
        auto lowerPos = lower_bound(lis, lis + len, num);
        int _pos = (int)(lower_bound(lis, lis + len, num) - lis);
        if (*lowerPos == INF) len++;
        *lowerPos = num;
        ans[i].first = _pos;
        ans[i].second = num;
    }
    cout << len << '\n';
    for (int i = N - 1; i >= 0; i--){
        if (ans[i].first == len - 1){
            stk.push(ans[i].second); len--;
        }
    }
    while (stk.size()){
        cout << stk.top() << ' ';
        stk.pop();
    }
    return 0;
}