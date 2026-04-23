// BOJ 1197 최소 스패닝 트리
#include <bits/stdc++.h>
using namespace std;

int v, e, ret;
        // {비용, 정점 번호}
vector<pair<int, int>> adj[10005];
bool check[10005];  // check[i] : i번째 정점이 mst에 속해있는가?
int cnt;  // 현재 선택된 간선의 수
// tuple<int, int, int> : {비용, 정점1, 정점2}
priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, greater<tuple<int, int, int>>> pq;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> v >> e;
    for (int i = 0; i < e; i++){
        int a, b, cost;
        cin >> a >> b >> cost;
        adj[a].push_back({cost, b});
        adj[b].push_back({cost, a});
    }
    check[1] = true;
    for (auto nxt : adj[1])
        pq.push({nxt.first, 1, nxt.second});
    while (cnt < v - 1){
        int cost, a, b;
        tie(cost, a, b) = pq.top();  pq.pop();
        if (check[b]) continue;
        ret += cost;
        check[b] = true;
        cnt++;
        for (auto nxt : adj[b]){
            if (!check[nxt.second]) pq.push({nxt.first, b, nxt.second});
        }
    }
    cout << ret;
}
