#include <bits/stdc++.h>
using namespace std;

int a[4][4], N, M, ret = 0;
string s;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++){
        cin >> s;
        for (int j = 0; j < M; j++){
            a[i][j] = s[j] - '0';
        }
    }

    for (int b = 0; b < (1 << (N * M)); b++){
        int sum = 0;
        // 1 = 세로로 자름, 0 = 가로로 자름
        for (int i = 0; i < N; i++){
            int cur = 0;
            for (int j = 0; j < M; j++){
                int k = i * M + j;
                // k번째 숫자를 가로로 자르고 있다면
                if ((b & (1 << k)) == 0){
                    cur = cur * 10 + a[i][j];
                }
                else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        for (int j = 0; j < M; j++){
            int cur = 0;
            for (int i = 0; i < N; i++){
                int k = i * M + j;
                // k번째 숫자를 세로로 자르고 있다면
                if (b & (1 << k)){
                    cur = cur * 10 + a[i][j];
                }
                else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        ret = max(ret, sum);
    }
    cout << ret << '\n';
    return 0;
}