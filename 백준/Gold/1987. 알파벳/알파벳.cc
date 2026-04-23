#include <bits/stdc++.h>
using namespace std;

int R, C, ret, check[100];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
char a[25][25];


void go(int y, int x, int cnt){
    ret = max(ret, cnt);
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= R || nx < 0 || nx >= C || check[a[ny][nx]]) continue;
        int next = a[ny][nx];
        if (check[next] == 0){
            check[next] = 1;
            go(ny, nx, cnt + 1);
            check[next] = 0;
        }
    }
    return;
}
    

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> R >> C;
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            cin >> a[i][j];
        }
    }
    check[a[0][0]] = 1;
    go(0, 0, 1);
    cout << ret << '\n';
    return 0;
}