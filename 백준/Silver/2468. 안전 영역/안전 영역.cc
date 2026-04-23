#include <bits/stdc++.h>
using namespace std;

int a[103][103], visited[103][103];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1}; 
int N, ny, nx, cnt, ret, H, tmp = -1;


void dfs(int y, int x){
    visited[y][x] = 1;
    for (int dir = 0; dir < 4; dir++){
        ny = y + dy[dir];
        nx = x + dx[dir];
        if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
        if (a[ny][nx] > H && !visited[ny][nx]) 
            dfs(ny, nx);
    }
    
}

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cin >> a[i][j];
        }   
    }
    while (H <= 100){
        memset(visited, 0, sizeof(visited)); 
        cnt = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (a[i][j] > H && !visited[i][j]) {
                    dfs(i, j); cnt++;
                }
            }
        }
        ret = max(cnt, tmp);
        tmp = ret;
        H++;
    }
    cout << ret << '\n';
    return 0;
}