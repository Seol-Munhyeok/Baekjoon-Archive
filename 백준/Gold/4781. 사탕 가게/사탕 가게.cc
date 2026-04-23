#include <bits/stdc++.h>
using namespace std;

int n, m, c, dp[10001], cal[5001], price[5001];
// dp[i] = 가격 i로 만들 수 있는 최대 칼로리를 저장

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    while (true){
        float f;
        cin >> n >> f;
        if (n == 0) break;
        m = f * 100 + 0.5;
        for (int i = 0; i < n; i++){
            cin >> c >> f;
            cal[i] = c; price[i] = f * 100 + 0.5;
        }
        memset(dp, 0, sizeof(dp));
        int ret = 0;
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= m; j++){
                if (j >= price[i]){
                    dp[j] = max(dp[j], dp[j - price[i]] + cal[i]);
                    ret = max(ret, dp[j]);
                }
            }
        }
        cout << ret << "\n";
    }
    return 0;
}