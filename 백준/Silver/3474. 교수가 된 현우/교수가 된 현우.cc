#include <bits/stdc++.h>
using namespace std;

int T, N;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> T;
    while (T--){
        cin >> N;
        int ret = 0;
        for (int i = 5; i <= N; i *= 5){
            ret += N / i;
        }
        cout << ret << '\n';
    }
    return 0;
}