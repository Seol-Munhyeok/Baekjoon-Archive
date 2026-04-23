#include <bits/stdc++.h>
using namespace std;

int N, M, lo, hi, ret, sum, mx, a[100004];

bool check(int mid){
    if (mx > mid) return false;
    int tmp = mid, cnt = 0;
    for (int i = 0; i < N; i++){
        if (mid - a[i] < 0){
            mid = tmp;
            cnt++;
        }
        mid -= a[i];
    }
    if (mid != tmp) cnt++;
    return cnt <= M;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++){
        cin >> a[i];
        mx = max(mx, a[i]);
        sum += a[i];
    }
    lo = mx; hi = sum;
    while (lo <= hi){
        int mid = (lo + hi) / 2;
        if (check(mid)){
            hi = mid - 1;
            ret = mid;
        }
        else lo = mid + 1;
    }
    cout << ret << '\n';
    return 0;
}