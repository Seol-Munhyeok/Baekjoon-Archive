#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll N, M, a[300004], ret = 1e18;

bool check(ll mid){
    ll num = 0;
    for (int i = 0; i < M; i++){
        num += a[i] / mid;
        if (a[i] % mid) num++;
    }
    return N >= num;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    ll lo = 1, hi = 0, mid;
    for (int i = 0; i < M; i++){
        cin >> a[i];
        hi = max(hi, a[i]);
    }
    while (lo <= hi){
        mid = (lo + hi) / 2;
        if (check(mid)){
            ret = min(ret, mid);
            hi = mid - 1;
        }
        else lo = mid + 1;
    }
    cout << ret << '\n';
    return 0;
}