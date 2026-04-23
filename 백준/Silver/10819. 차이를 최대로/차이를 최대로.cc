#include <bits/stdc++.h>
using namespace std;

int n, ret, a[10];

int go(int a[]){
    int tmp = 0;
    for (int i = 0; i <= n - 2; i++){
        tmp += abs(a[i] - a[i + 1]);
    }
    return tmp;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    sort(a, a + n);
    do{
        ret = max(ret, go(a));
    } while (next_permutation(a, a + n));
    cout << ret << "\n";
    return 0;
}