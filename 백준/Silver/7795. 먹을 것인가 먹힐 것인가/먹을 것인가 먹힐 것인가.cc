#include <bits/stdc++.h>
using namespace std;

int T, N, M, ret;

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> T;
    while (T--){
        cin >> N >> M;
        vector<int> a(N), b(M);
        for (int i = 0; i < N; i++) cin >> a[i];
        for (int i = 0; i < M; i++) cin >> b[i];
        sort(a.begin(), a.end());
        ret = 0;
        for (int i = 0; i < M; i++) {
            int tmp = (int)(upper_bound(a.begin(), a.end(), b[i]) - a.begin());
            ret += (N - tmp);
        }
        cout << ret << '\n';
    }
    return 0;
}