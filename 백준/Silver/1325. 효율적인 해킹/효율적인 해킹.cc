#include <bits/stdc++.h>
using namespace std;

int dp[10003], mx, visited[10003], N, M, a, b;
vector<int> adj[10003];

int dfs(int here){
    visited[here] = 1;
    int ret = 1;
    for (int there : adj[here]){
        if (!visited[there]) ret += dfs(there);
    }
    return ret;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    while (M--){
        cin >> a >> b;
        adj[b].push_back(a);
    }
    for (int i = 1; i <= N; i++){
        memset(visited, 0, sizeof(visited));
        dp[i] = dfs(i);
        mx = max(dp[i], mx);
    }
    for (int i = 1; i <= N; i++) if (mx == dp[i]) cout << i << ' ';
    return 0;
}