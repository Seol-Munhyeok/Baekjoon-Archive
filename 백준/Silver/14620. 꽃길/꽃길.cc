#include <bits/stdc++.h>
using namespace std;

int N, a[20][20], visited[20][20], ret = 1e9;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};

bool check(int y, int x){
    // 해당 위치에 꽃을 심을 수 있는지 체크
    if (visited[y][x]) return 0;
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) 
            return 0;
    }
    return 1;
}

int setFlower(int y, int x){
    // 꽃을 두고 그 지역의 땅 값 계산
    visited[y][x] = 1;
    int s = a[y][x];
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        visited[ny][nx] = 1;
        s += a[ny][nx];
    }
    return s;
}

void eraseFlower(int y, int x){
    visited[y][x] = 0;
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        visited[ny][nx] = 0;
    }
}

void go(int cnt, int hap){
    // 모든 지역 탐색하면서 꽃을 심을 수 있으면, 심고 땅 값을 누적해서 재귀 호출
    if (cnt == 3) {
        ret = min(ret, hap);
        return;
    }
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            if (check(i, j)){
                go(cnt + 1, hap + setFlower(i, j));
                eraseFlower(i, j);
            }
        }
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
    go(0, 0);
    cout << ret << '\n';
    return 0;
}