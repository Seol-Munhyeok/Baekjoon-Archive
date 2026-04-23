#include <bits/stdc++.h>
using namespace std;

int N, M;
int a[10];

void go(int k){
    if (k == M){
        for (int i = 0; i < M; i++){
            cout << a[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = 1; i <= N; i++){
        a[k] = i;
        go(k + 1);
    }
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    go(0);
    return 0;
}