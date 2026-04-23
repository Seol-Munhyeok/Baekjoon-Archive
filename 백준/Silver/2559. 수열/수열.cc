#include <bits/stdc++.h>
using namespace std;
int n, k, tmp, psum[100001], ret = -1e9;
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> n >> k;
    for (int i = 1; i <= n; i++){
        cin >> tmp; psum[i] = psum[i - 1] + tmp;
    }
    for (int i = k; i <= n; i++){
        ret = max(ret, psum[i] - psum[i - k]);
    }
    cout << ret << '\n';
    return 0;
}