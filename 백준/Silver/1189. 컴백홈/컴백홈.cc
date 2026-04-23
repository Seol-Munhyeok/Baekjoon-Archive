#include <bits/stdc++.h>
using namespace std;

int R, C, K, visited[10][10];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
char a[10][10];

int go(int y, int x){
    if (y == 0 && x == C - 1){
        if (K == visited[y][x]) return 1;
        return 0;
    }
    int ret = 0;
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
        if (visited[ny][nx] || a[ny][nx] == 'T') continue;
        visited[ny][nx] = visited[y][x] + 1;
        ret += go(ny, nx);
        visited[ny][nx] = 0;
    }
    return ret;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> R >> C >> K;
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            cin >> a[i][j];
        }
    }
    visited[R - 1][0] = 1;
    cout << go(R - 1, 0) << '\n';
    return 0;
}