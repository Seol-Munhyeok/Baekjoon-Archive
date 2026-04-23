#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int N, C, num;
map<ll, int> mp;
vector<ll> v, v2;

bool cmp(ll a, ll b){
    if (mp[a] == mp[b])
        return find(v2.begin(), v2.end(), a) < find(v2.begin(), v2.end(), b);
    return mp[a] > mp[b];
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> C;
    while (N--){
        cin >> num;
        v.push_back(num);
        mp[num]++;
    }
    v2 = v;
    sort(v.begin(), v.end(), cmp);
    for (int i : v) cout << i << ' ';
    return 0;
}