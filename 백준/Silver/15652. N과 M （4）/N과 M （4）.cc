#include <bits/stdc++.h>
using namespace std;

int N, M;
int a[10];

void go(int k, int start){
    if (k == M){
        for (int i = 0; i < M; i++){
            cout << a[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = start; i <= N; i++){
        a[k] = i;
        go(k + 1, i);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    go(0, 1);
    return 0;
}