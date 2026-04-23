#include <bits/stdc++.h>
using namespace std;

int x, y;
double p, q, ret;
int notPrimes[] = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
double dp[20][20][20];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> x >> y;
    p = x / 100.0;
    q = y / 100.0;
    dp[1][0][0] = (1 - p) * (1 - q);
    dp[1][0][1] = (1 - p) * q;
    dp[1][1][0] = p * (1 - q);
    dp[1][1][1] = p * q;
    for (int i = 2; i <= 18; i++){
        for(int a = 0; a <= 18; a++){
            for(int b = 0; b <= 18; b++){
                dp[i][a][b] += dp[i - 1][a - 1][b - 1] * p * q;
                dp[i][a][b] += dp[i - 1][a][b - 1] * (1 - p) * q;
                dp[i][a][b] += dp[i - 1][a - 1][b] * p * (1 - q);
                dp[i][a][b] += dp[i - 1][a][b] * (1 - p) * (1 - q);
            }
        }
    }
    for (int i : notPrimes){
        for (int j : notPrimes){
            ret += dp[18][i][j];
        }
    }
    cout << 1 - ret << "\n";
    return 0;
}