#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9, MAX = 1004;
char a[MAX][MAX];
int R, C, sx, sy, ret, y, x;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
int fire_check[MAX][MAX], person_check[MAX][MAX];

bool isIn(int a, int b){
    return (a >= 0) && (a < R) && (b >= 0) && (b < C);
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    queue<pair<int, int>> q;
    cin >> R >> C;
    fill(&fire_check[0][0], &fire_check[0][0] + MAX * MAX, INF);
    for (int i = 0; i < R; i++){
        for (int j = 0; j < C; j++){
            cin >> a[i][j];
            if (a[i][j] == 'F') {
                fire_check[i][j] = 1; q.push({i, j});
            }
            else if (a[i][j] == 'J'){
                sy = i; sx = j;
            }
        }
    }

    // 불의 최단 경로 탐색
    while (q.size()){
        tie(y, x) = q.front();
        q.pop();
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isIn(ny, nx)) continue;
            if (fire_check[ny][nx] != INF || a[ny][nx] == '#') continue;
            fire_check[ny][nx] = fire_check[y][x] + 1;
            q.push({ny, nx});
        }
    }

    // 지훈의 최단 경로 탐색
    person_check[sy][sx] = 1;
    q.push({sy, sx});
    while (q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        // 지훈이 탈출했다면
        if (y == 0 || y == R - 1 || x == 0 || x == C - 1){
            ret = person_check[y][x];
            break;
        }
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isIn(ny, nx)) continue;
            if (person_check[ny][nx] || a[ny][nx] == '#') continue;
            // 지훈은 불보다 먼저 도착해야함
            if (fire_check[ny][nx] <= person_check[y][x] + 1) continue;
            person_check[ny][nx] = person_check[y][x] + 1;
            q.push({ny, nx});
        }
    }
    if (ret != 0) cout << ret << '\n';
    else cout << "IMPOSSIBLE\n";
    return 0;

}