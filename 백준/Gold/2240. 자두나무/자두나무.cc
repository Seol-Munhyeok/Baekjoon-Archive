#include <bits/stdc++.h>
using namespace std;

int dp[1004][32][2], b[1004], T, W;

int go(int time, int tree, int cnt){
    if (cnt < 0) return -1e9;
    if (time == T) return 0;
    int &ret = dp[time][tree][cnt];
    if (ret != -1) return ret;
    return ret = max(go(time + 1, tree^1, cnt - 1), go(time + 1, tree, cnt)) + (tree == b[time] - 1);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    memset(dp, -1, sizeof(dp));
    cin >> T >> W;
    for (int i = 0; i < T; i++) cin >> b[i];
    cout << max(go(0, 0, W), go(0, 1, W - 1)) << '\n';
    return 0;
}