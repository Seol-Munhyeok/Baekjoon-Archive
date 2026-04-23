#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, s, e, ret, a[100004], cnt[100004];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> a[i];
    }
    while (e < N){
        if (!cnt[a[e]]){
            cnt[a[e]]++;
            e++;
        }
        else {
            ret += (e - s);
            cnt[a[s]]--;
            s++;
        }
    }
    ret += (((e - s) * (e - s + 1)) / 2);
    cout << ret << '\n';
    return 0;
}