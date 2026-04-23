#include <bits/stdc++.h>
using namespace std;

int V, E, K, u, v, w;
vector<pair<int, int>> adj[20001];
int dist[20001];
const int INF = 1e9;
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> V >> E >> K;
    fill(dist, dist + 20001, INF);  // 처음 거리 무한대로 초기화
    for (int i = 0; i < E; i++){
        cin >> u >> v >> w;
        adj[u].push_back(make_pair(w, v));
    }
    // 시작 위치 초기화
    pq.push(make_pair(0, K));
    dist[K] = 0;
    // 로직
    while (pq.size()){
        // 지금 정점 부터 최소거리인 정점부터 탐색
        int here = pq.top().second;
        int here_dist = pq.top().first;
        pq.pop();
        // 해당 정점까지의 거리 중 더 짧은 거리를 담는 첫 번째 정점만을 처리한다.
        if (dist[here] != here_dist) continue;
        // "내가 탐색하려는 정점"보다 "나의 정점 + 그 정점까지의 거리"가 더 작으면 갱신(완화)
        for (auto there : adj[here]){
            int _dist = there.first;
            int _there = there.second;
            if (dist[_there] > dist[here] + _dist){
                dist[_there] = dist[here] + _dist;
                pq.push(make_pair(dist[_there], _there));
            }
        }
    }
    for (int i = 1; i <= V; i++){
        if (dist[i] == INF) cout << "INF" << '\n';
        else cout << dist[i] << '\n';
    }
    return 0;
}