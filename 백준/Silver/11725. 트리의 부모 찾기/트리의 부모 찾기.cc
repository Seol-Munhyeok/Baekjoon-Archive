// BOJ 11725
#include <bits/stdc++.h>
using namespace std;

int N, u, v;
vector<int> adj[100002];
int p[100002];  // 트리에서는 visited 배열 대신, 부모를 저장하면 된다.

void dfs(int here){
    for (auto nxt : adj[here]){
        if (p[here] == nxt) continue;
        p[nxt] = here;
        dfs(nxt);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    dfs(1);
    for (int i = 2; i <= N; i++) cout << p[i] << "\n";
    return 0;
}