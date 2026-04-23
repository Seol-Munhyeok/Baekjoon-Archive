#include <bits/stdc++.h>
using namespace std;

int N;
double a, ret, tmp = 1;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    while (N--){
        cin >> a;
        tmp *= a;
        ret = max(ret, tmp);
        if (tmp < 1) tmp = 1;
    }
    cout.precision(3);
    cout << fixed << ret << '\n';
    return 0;
}