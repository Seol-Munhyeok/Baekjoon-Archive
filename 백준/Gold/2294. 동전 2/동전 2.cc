#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
int n, k, tmp, dp[10004];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n >> k;
    fill(dp, dp + 10004, INF);
    dp[0] = 0;
    for (int i = 0; i < n; i++){
        cin >> tmp;
        for (int j = tmp; j <= k; j++){
            dp[j] = min(dp[j], dp[j - tmp] + 1);
        }
    }
    cout << (dp[k] == INF ? -1 : dp[k]) << '\n';
    return 0;
}