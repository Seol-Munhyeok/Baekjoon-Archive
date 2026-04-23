#include <bits/stdc++.h>
using namespace std;

int N, K, w, v, ret, dp[100001];
// dp[i] = 무게 i로 만들 수 있는 최대 가치를 저장

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> K;
    while (N--){
        cin >> w >> v;
        for (int weight = K; weight >= w; weight--){
            dp[weight] = max(dp[weight], dp[weight - w] + v);
        }
    }
    cout << dp[K] << "\n";
    return 0;
}