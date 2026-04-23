#include <bits/stdc++.h>
using namespace std;

int N, M, x, y, ret, visited[304][304];
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
char a[304][304];
queue<int> q;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int x1, y1, x2, y2;
    cin >> N >> M;
    cin >> y1 >> x1 >> y2 >> x2;
    y1--; x1--; y2--; x2--;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < M; j++){
            cin >> a[i][j];
        }
    }
    q.push(1000 * y1 + x1);   // (3, 4)라면 위치를 3004로 표현
    visited[y1][x1] = 1;
    int cnt = 0;
    while (a[y2][x2] != '0'){
        cnt++;
        queue<int> temp;
        while (q.size()){
            int y = q.front() / 1000;
            int x = q.front() % 1000;
            q.pop();
            for (int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
                visited[ny][nx] = cnt;
                if (a[ny][nx] != '0'){
                    a[ny][nx] = '0';
                    temp.push(1000 * ny + nx);
                }
                else q.push(1000 * ny + nx);
            }
        }
        q = temp;
    }
    cout << visited[y2][x2] << '\n';
    return 0;
}