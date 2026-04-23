#include <bits/stdc++.h>
using namespace std;

int parent[50], visited[50];
vector<int> adj[50];
int N, M, cnt, root;

void dfs(int here){
    visited[here] = 1;
    if (adj[here].empty()) cnt++;
    for (int there : adj[here]){
        if (!visited[there]) dfs(there);
    }
    return;
}

int main(){
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> parent[i];
    }
    for (int i = 0; i < N; i++){
        if (parent[i] == -1) root = i;
        else adj[parent[i]].push_back(i);
    }   
    cin >> M;
    
    if (root == M) cnt = 0;
    else if (N == 2) cnt = 1;
    else {
        auto t = find(adj[parent[M]].begin(), adj[parent[M]].end(), M);
        adj[parent[M]].erase(t);
        dfs(root);
    } 
    cout << cnt << '\n';
    return 0;
}
