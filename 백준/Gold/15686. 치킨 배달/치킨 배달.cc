#include <bits/stdc++.h>
using namespace std;

int N, M, tmp;
vector<pair<int, int>> ck, ho, v;  // ck : chicken, ho : house
vector<int> ret;

int distance(pair<int, int> x, pair<int, int> y){
    return abs(x.first - y.first) + abs(x.second - y.second);
}

int go(vector<pair<int, int>> v){
    // 주어진 치킨 집 좌표를 인자로 받아 최소 치킨 거리 출력
    int ret = 0;
    for (int i = 0; i < ho.size(); i++){
        int mn = 1e9;
        for (int j = 0; j < v.size(); j++){
            mn = min(mn, distance(ho[i], v[j]));
        }
        ret += mn;
    }
    return ret;
}

void combi(int start, int k){
    if (v.size() == k) {
        ret.push_back(go(v));
        return;
    }
    for (int i = start + 1; i < ck.size(); i++){
        v.push_back(ck[i]);
        combi(i, k);
        v.pop_back();
    }
    return;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cin >> tmp;
            if (tmp == 1) ho.push_back({i, j});
            if (tmp == 2) ck.push_back({i, j});
        }
    }
    
    // ck 벡터에서 최대 M개 까지 뽑는 벡터 생성
    for (int i = 1; i <= M; i++){
        v.clear();
        combi(-1, i);
    }

    cout << *min_element(ret.begin(), ret.end());
    
    return 0;
}