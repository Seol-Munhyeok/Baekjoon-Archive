#include <bits/stdc++.h>
using namespace std;

string s, t;
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> s;
    t = s;
    reverse(s.begin(), s.end());
    if (t == s) cout << 1;
    else cout << 0;
    return 0;
}