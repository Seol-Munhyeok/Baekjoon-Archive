#include <bits/stdc++.h>
using namespace std;

int T, N;
string A, B;
map<string, int> mp;

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> T;
    while (T--){
        cin >> N;
        int ret = 1;
        while (N--){
            cin >> A >> B;
            mp[B]++;
        }
        for (auto it : mp) ret *= (it.second + 1);
        cout << ret - 1 << '\n';  // 전부 안 입는 경우의 수 1개 제외
        mp.clear();
    }

    return 0;
}