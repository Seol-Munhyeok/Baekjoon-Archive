#include <bits/stdc++.h>
using namespace std;

const int MAX = 500000;
int visited[2][MAX + 4], N, K, ok, turn = 1;


int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> K;
    if (N == K) { cout << 0 << '\n'; return 0; } // 반례
    queue<int> q;
    visited[0][N] = 1;
    q.push(N);
    while (q.size()){
        K += turn;
        if (K > MAX) break;
        if (visited[turn % 2][K]){
            ok = true;
            break;
        }
        int qSize = q.size(); // BFS에서 깊이를 체크하는 방법
        for (int i = 0; i < qSize; i++){
            int x = q.front(); q.pop();
            for (int nx : {x + 1, x - 1, x * 2}){
                if (nx < 0 || nx > MAX || visited[turn % 2][nx]) continue;
                visited[turn % 2][nx] = visited[(turn + 1) % 2][x] + 1;
                if (nx == K) { ok = 1; break; }
                q.push(nx);
            }
            if (ok) break;
        }
        if (ok) break;
        turn++;
    }
    if (ok) cout << turn << '\n';
    else cout << -1 << '\n';

    return 0;
}