#include <bits/stdc++.h>
using namespace std;

int N, cnt;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (cnt = 0; N != 0; cnt++){
        N &= (N - 1);
    }
    cout << cnt << '\n';
    return 0;
}