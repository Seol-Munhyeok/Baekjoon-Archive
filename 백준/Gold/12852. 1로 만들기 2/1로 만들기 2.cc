#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000000, INF = 1e9;
int N, dp[MAX + 4];

void go(int here){
    if (here == 0) return;
    cout << here << ' ';
    if (here % 3 == 0 && dp[here] == (dp[here / 3] + 1)) go(here / 3);
    else if (here % 2 == 0 && dp[here] == (dp[here / 2] + 1)) go(here / 2);
    else if ((here - 1 >= 0) && (dp[here] == (dp[here - 1] + 1))) go(here - 1);
    return;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    fill(dp, dp + MAX + 4, INF);
    dp[1] = 0;
    for (int i = 1; i <= N; i++){
        if (!(i % 3)) dp[i] = min(dp[i / 3] + 1, dp[i]);
        if (!(i % 2)) dp[i] = min(dp[i / 2] + 1, dp[i]);
        dp[i] = min(dp[i - 1] + 1, dp[i]);
    }
    cout << dp[N] << "\n";
    go(N);
    return 0;
}