#include <bits/stdc++.h>
using namespace std;

int R, C, check[100];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
char a[25][25];
vector<int> result;

bool canNotMove(int y, int x){
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
        if (check[a[ny][nx]] == 0) return false;
    }
    return true;
}

void go(int y, int x, int cnt){
    if (canNotMove(y, x)){
        result.push_back(cnt);
        return;
    }
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= R || nx < 0 || nx >= C || check[a[ny][nx]]) continue;
        check[a[ny][nx]] = 1;
        go(ny, nx, cnt + 1);
        check[a[ny][nx]] = 0;
    }
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
    cout << *max_element(result.begin(), result.end()) << '\n';
    return 0;
}