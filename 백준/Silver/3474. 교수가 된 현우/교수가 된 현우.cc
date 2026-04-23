#include <bits/stdc++.h>
using namespace std;

int T, N;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> T;
    while (T--){
        cin >> N;
        int ret2 = 0, ret5 = 0;
        for (int i = 2; i <= N; i *= 2){
            ret2 += N / i;
        }
        for (int i = 5; i <= N; i *= 5){
            ret5 += N / i;
        }
        cout << min(ret2, ret5) << '\n';
    }
    return 0;
}