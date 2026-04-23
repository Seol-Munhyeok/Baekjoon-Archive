#include <bits/stdc++.h>
using namespace std;

const int MAX = 200000;
int visited[MAX + 4], N, K;
long long cnt[MAX + 4];



int main(){
    cin >> N >> K;
    // 반례
    if (N == K) {
        cout << "0\n1";
        return 0;
    }
    visited[N] = 1;
    cnt[N] = 1;
    queue<int> q;
    q.push(N);
    while (q.size()){
        int now = q.front();
        q.pop();
        for (int next : {now - 1, now + 1, now * 2}){
            if (next >= 0 && next <= MAX){
                if (!visited[next]){
                    q.push(next);
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                }
                // 최단경로로 가는 다른 경우의 수가 있을 경우
                else if (visited[next] == visited[now] + 1){
                    cnt[next] += cnt[now];
                }
            }
        }
    }
    cout << visited[K] - 1 << '\n';
    cout << cnt[K] << '\n';
    return 0;
}