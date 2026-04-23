// BOJ 1197 최소 스패닝 트리
#include <bits/stdc++.h>
using namespace std;

tuple<int, int, int> edge[100005];
// 가중치, 정점1, 정점2
int V, E;

int p[10005];  // 부모 노드를 저장
int _size[10005];  // 각 노드를 루트로 하는 서브트리의 노드의 개수를 저장

int find_set(int x){
    // 자신이 속한 트리의 루트를 찾음
    if (x != p[x]) p[x] = find_set(p[x]);
    return p[x];
    /* O(h), h는 트리의 높이
       h는 최악의 경우 O(n)*/
}

int find_set_path_compression(int x){
    // 루트를 찾아 올라가면서 트리의 높이를 줄여나감
    while (x != p[x]){
        p[x] = p[p[x]];
        x = p[x];
    }
    return p[x];
}

void _union(int u, int v){
    // 한 트리의 루트를 다른 트리의 루트의 자식 노드로 만든다.
    int x = find_set(u);
    int y = find_set(v);
    p[x] = y;
}


bool weighted_union(int u, int v){
    // 두 집합을 union 할 때 작은 트리의 루트를 큰 트리의 루트의 자식으로 만든다.
    // u, v가 같은 그룹에 속하면 false 반환
    int x = find_set_path_compression(u);
    int y = find_set_path_compression(v);
    if (x == y) return false;
    if (_size[x] > _size[y]){
        p[y] = x;
        _size[x] = _size[x] + _size[y];
    }
    else {
        p[x] = y;
        _size[y] = _size[y] + _size[x];
    }
    return true;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> V >> E;
    for (int i = 0; i < E; i++){
        int a, b, cost;
        cin >> a >> b >> cost;
        edge[i] = {cost, a, b};
    }
    // p, size 배열 초기화
    for (int i = 0; i < V; i++){
        p[i] = i;
        _size[i] = 1;
    }
    sort(edge, edge + E);  // tuple의 대소비교는 앞에서 부터, 즉 비용에 따라 정렬
    int cnt = 0;
    int ret = 0;
    for (int i = 0; i < E; i++){
        int a, b, cost;
        tie(cost, a, b) = edge[i];
        if (!weighted_union(a, b)) continue;  // 같은 그룹에 속하면 pass
        ret += cost;
        cnt++;
        if (cnt == V - 1) break;  // V-1개의 간선이 선택되면 종료
    }
    cout << ret;
    return 0;
}