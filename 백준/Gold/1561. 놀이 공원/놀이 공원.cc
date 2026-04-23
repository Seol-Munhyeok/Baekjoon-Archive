#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, M, ret, tmp, a[10004];

bool check(ll mid){
    // 특정 시간 mid 동안 N명 이상을 태울 수 있나 판단
    tmp = M;  // tmp : 태운 아이 수
    for (ll i = 0; i < M; i++) tmp += (mid / a[i]);
    return tmp >= N;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (ll i = 0; i < M; i++) cin >> a[i];
    // 놀이기구 수가 더 많으면 바로 다 태우고 종료
    if (N <= M) {
        cout << N << '\n';
        return 0;
    }
    // 모든 아이가 다 탈 때까지 걸리는 시간의 최소 상한(ret)을 구한다.
    ll lo = 0, hi = 6e10 + 4;
    while (lo <= hi){
        ll mid = (lo + hi) / 2;
        if (check(mid)){
            ret = mid;
            hi = mid - 1;
        }
        else lo = mid + 1;
    }
    tmp = M;  // 0초일 때 M명을 다 태우고
    // ret를 기반으로 한 명씩 태워보면서 답을 구함
    // 1초 전에 들어온 아이들 수를 찾고 그 다음에 if (tmp % 운행시간 == 0)이면
    // 이전에 탄 아이가 내리고 다음 아이가 탈 수 있다.
    for (ll i = 0; i < M; i++) tmp += ((ret - 1) / a[i]);
    for (ll i = 0; i < M; i++){
        if (ret % a[i] == 0) tmp++;
        if (tmp == N){
            cout << i + 1 << '\n';
            return 0;
        }
    }
    return 0;
}