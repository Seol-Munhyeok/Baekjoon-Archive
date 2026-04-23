#include <bits/stdc++.h>
using namespace std;
int N, len, num;
pair<int, int> a[104];
int lis[104];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> a[i].first >> a[i].second;
    }
    sort(a, a + N);
    for (int i = 0; i < N; i++){
        auto lowerPos = lower_bound(lis, lis + len, a[i].second);
        if (*lowerPos == 0) len++;
        *lowerPos = a[i].second;
    }
    cout << N - len << '\n';
    return 0;
}