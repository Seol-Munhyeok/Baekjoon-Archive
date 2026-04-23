#include <bits/stdc++.h>
using namespace std;

int N, dp[101], cost[101], happy[101];
//dp[i] = 최대 체력 i로 얻을 수 있는 최대 기쁨

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) cin >> cost[i];
    for (int i = 0; i < N; i++) cin >> happy[i];
    for (int i = 0; i < N; i++){
        for (int j = 100; j > cost[i]; j--){
            dp[j] = max(dp[j], dp[j - cost[i]] + happy[i]);
        }
    }
    cout << dp[100] << '\n';
    return 0;
}