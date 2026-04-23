#include <bits/stdc++.h>
using namespace std;

int a[101][101], visited[101][101];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
vector<int> v; 
int N, M, K, sy, ey, sx, ex, ny, nx, cnt;

int dfs(int y, int x){
    visited[y][x] = 1;
    int area = 0;
    for (int dir = 0; dir < 4; dir++){
        ny = y + dy[dir];
        nx = x + dx[dir];
        if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
        if (a[ny][nx] == 0 && !visited[ny][nx]) {
            area += dfs(ny, nx);
        }
    }
    return area + 1;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> M >> N >> K;
    while (K--){
        cin >> sx >> sy >> ex >> ey;
        for (int i = M - ey; i < M - sy; i++)
            for (int j = sx; j < ex; j++) a[i][j] = 1;
    }
    
    for (int i = 0; i < M; i++){
        for (int j = 0; j < N; j++){
            if (a[i][j] == 0 && !visited[i][j]){
                int tmp = dfs(i, j);
                cnt++;
                v.push_back(tmp);
            }
        }
    }

    cout << cnt << '\n';
    sort(v.begin(), v.end());
    for (int i : v) cout << i << ' ';
    return 0;
}