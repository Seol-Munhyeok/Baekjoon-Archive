#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll A, B, C;
ll sol(ll a, ll b, ll c){
    ll tmp;
    if (b == 1) return a % c;
    else {
        tmp = sol(a, b/2, c);
        if (b % 2 == 0) return (tmp * tmp) % c;
        else return ((tmp * tmp) % c * a) % c;
    }
}

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> A >> B >> C;
    cout << sol(A, B, C) << '\n';
    return 0;
}