#include <bits/stdc++.h>
using namespace std;

int a[55][55], visited[55][55];
int T, M, N, K, ny, nx, ret;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};

void dfs(int y, int x){
    visited[y][x] = 1;
    for (int dir = 0; dir < 4; dir++){
        ny = y + dy[dir];
        nx = x + dx[dir];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if (a[ny][nx] == 1 && !visited[ny][nx]){
            dfs(ny, nx);
        }   
    }
    return;
}

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> T;
    while (T--){
        memset(a, 0, sizeof(a)); memset(visited, 0, sizeof(visited)); 
        ret = 0;
        cin >> M >> N >> K;
        while (K--){
            int X, Y;
            cin >> X >> Y;
            a[Y][X] = 1;
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (a[i][j] == 1 && !visited[i][j]) {dfs(i, j); ret++;}
            }
        }
        cout << ret << '\n';
    }
    return 0;
}