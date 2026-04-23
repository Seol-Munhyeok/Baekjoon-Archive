#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll N, h, ret;
stack<pair<ll, ll>> stk;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    while (N--){
        cin >> h;
        int cnt = 1;
        while (stk.size() && stk.top().first <= h){
            ret += stk.top().second;
            if (stk.top().first == h){
                cnt = stk.top().second + 1;
            } else {
                cnt = 1;
            }
            stk.pop();
        }
        if (stk.size()) ret++;
        stk.push({h, cnt});
    }
    cout << ret << '\n';
    return 0;
}