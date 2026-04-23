#include <bits/stdc++.h>
using namespace std;

int N, dp[21][101], L[2002], J[2002];
//dp[i][w] = 최대 체력이 w인 경우 i번째까지 판단했을 때의 최대 기쁨

int knapsack(int i, int W){
    if (i <= 0 || W <= 0) return 0;
    int &ret = dp[i][W];
    if (ret != -1) return ret;
    if (L[i] >= W) return knapsack(i - 1, W);
    else {
        int not_included = knapsack(i - 1, W);
        int included = knapsack(i - 1, W - L[i]) + J[i];
        return ret = max(not_included, included);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 1; i <= N; i++) cin >> L[i];
    for (int i = 1; i <= N; i++) cin >> J[i];
    memset(dp, -1, sizeof(dp));
    cout << knapsack(N, 100) << '\n';
    return 0;
}