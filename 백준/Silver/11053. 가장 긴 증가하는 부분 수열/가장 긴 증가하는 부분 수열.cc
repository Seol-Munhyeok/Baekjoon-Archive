#include <bits/stdc++.h>
using namespace std;

int N, lis[1001], len, num;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++){
        cin >> num;
        auto lowerPos = lower_bound(lis, lis + len, num);
        if (*lowerPos == 0) len++;
        *lowerPos = num;
    }
	cout << len << '\n';
    return 0;
}