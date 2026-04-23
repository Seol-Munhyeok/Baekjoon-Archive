#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000000;
int N, dp[MAX + 4];
vector<int> v;
int go(int n){
    // 기저 사례
    if (n == 1) return 0;
    if (n == 2 || n == 3) return 1;
    // 메모이제이션
    int &ret = dp[n];
    if (ret != -1) return ret;
    // 로직
    if (n % 6 == 0) return ret = min({go(n / 3), go(n / 2), go(n - 1)}) + 1;
    if (n % 3 == 0) return ret = min(go(n / 3), go(n - 1)) + 1;
    if (n % 2 == 0) return ret = min(go(n / 2), go(n - 1)) + 1;
    return ret = go(n - 1) + 1;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    memset(dp, -1, sizeof(dp));
    dp[1] = 0;
    dp[2] = dp[3] = 1;
    for (int i = 1; i <= MAX; i++) {
        go(i);
    }
    cin >> N;
    cout << dp[N] << '\n';
    while (N != 0){
        cout << N << ' ';
        if (dp[N] == dp[N - 1] + 1) N -= 1;
        else if (N % 2 == 0 && dp[N] == dp[N / 2] + 1) N /= 2;
        else if (N % 3 == 0 && dp[N] == dp[N / 3] + 1) N /= 3;
    }
    return 0;
}