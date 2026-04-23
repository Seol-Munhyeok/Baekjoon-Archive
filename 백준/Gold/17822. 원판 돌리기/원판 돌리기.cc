#include <bits/stdc++.h>
using namespace std;

int N, M, T, x, d, k, a[55][55], visited[55][55], y, ret;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
bool flag;

void dfs(int y, int x){
    for (int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = (x + dx[i] + M) % M;
        if (ny < 0 || ny >= N || visited[ny][nx]) continue;
        if (a[y][x] && a[y][x] == a[ny][nx]) {
            flag = 0;
            visited[y][x] = visited[ny][nx] = 1;
            dfs(ny, nx);
        }
    }
}

bool findAdj(){
    memset(visited, 0, sizeof(visited));
    flag = 1;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            if (!visited[i][j]) dfs(i, j);
        }
    }
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            if (visited[i][j]) a[i][j] = 0;
        }
    }
    return flag;
}

void _rotate(int y, int d, int k){
    vector<int> v;
    for (int i = 0; i < M; i++){
        v.push_back(a[y][i]);
    }
    if (d == 0) rotate(v.begin(), v.begin() + M - k, v.end());
    else if (d == 1) rotate(v.begin(), v.begin() + k, v.end());
    for (int i = 0; i < M; i++) a[y][i] = v[i];
    return;
}

void setAverage(){
    int sum = 0, cnt = 0;
    double avg;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            if (a[i][j]) {
                sum += a[i][j];
                cnt++;
            }
        }
    }
    avg = (double) sum / (double) cnt;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            if (a[i][j] > 0 && a[i][j] > avg) a[i][j]--;
            else if (a[i][j] > 0 && a[i][j] < avg) a[i][j]++;
        }
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M >> T;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            cin >> a[i][j];
        }
    }
    for (int i = 0; i < T; i++){
        cin >> x >> d >> k;
        for (int j = x - 1; j < N; j += x){
            _rotate(j, d, k);
        }
        if (findAdj()) setAverage();
    }
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            ret += a[i][j];
        }
    }
    cout << ret << '\n';
    return 0;
}