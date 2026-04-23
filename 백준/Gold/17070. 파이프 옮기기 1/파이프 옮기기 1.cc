#include <bits/stdc++.h>
using namespace std;

int N, a[20][20], ret;
const int dy[] = {0, 1, 1};
const int dx[] = {1, 0, 1};

void dfs(int y, int x, int dir){
    if (y == N - 1 && x == N - 1){
        ret++;
        return;
    }
    for (int i = 0; i < 3; i++){
        // 가로 -> 세로, 세로 -> 가로 붙이는 건 안됨.
        if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) continue;
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= N || nx < 0 || nx >= N || a[ny][nx] == 1) continue;
        // 대각선 체크
        if (i == 2 && (a[y + 1][x] == 1 || a[y][x + 1] == 1)) continue;
        dfs(ny, nx, i);
    }
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cin >> a[i][j];
        }
    }
    dfs(0, 1, 0);
    cout << ret << '\n';
    return 0;
}