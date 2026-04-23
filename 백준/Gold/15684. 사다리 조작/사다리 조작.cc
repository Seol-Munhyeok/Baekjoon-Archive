#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
int N, M, H, a, b, ret = INF, visited[34][34];

bool check(){
    for (int i = 1; i <= N; i++){
        int start = i;
        for (int j = 1; j <= H; j++){
            if (visited[j][start]) start++;
            else if (visited[j][start - 1]) start--;
        }
        if (start != i) return false;
    }
    return true;
}

void go(int here, int cnt){
    if (cnt > 3 || cnt >= ret) return;
    if (check()){
        ret = min(ret, cnt);
        return;
    }
    for (int i = here; i <= H; i++){
        for (int j = 1; j < N; j++){
            if (visited[i][j] || visited[i][j - 1] || visited[i][j + 1]) continue;
            visited[i][j] = 1;
            go(i, cnt + 1);
            visited[i][j] = 0;
        }
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M >> H;
    for (int i = 0; i < M; i++){
        cin >> a >> b;
        visited[a][b] = 1;
    }
    go(1, 0);
    cout << ((ret == INF) ? -1 : ret) << '\n';
    return 0;
}