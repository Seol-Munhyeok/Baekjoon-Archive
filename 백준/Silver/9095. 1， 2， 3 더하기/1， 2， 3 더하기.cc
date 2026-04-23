#include <bits/stdc++.h>
using namespace std;

int K, T;
int dp[32];
int main(){
    cin >> T;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    // dp[i] = dp[i - 1] 경우의 수에 1 추가
            // + dp[i - 2] 경우의 수에 2 추가
            // + dp[i - 3] 경우의 수에 3 추가 
    for (int i = 4; i <= 30; i++){
       dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    while (T--){
        cin >> K;
        cout << dp[K] << "\n";
    }
    return 0;
}