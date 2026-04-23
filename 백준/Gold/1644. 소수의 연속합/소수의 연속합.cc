#include <bits/stdc++.h>
using namespace std;

const int MAX = 4000001;
int N, a[MAX / 2], p, hi, lo, ret, sum;
bool sieve[MAX];

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for (int i = 2; i <= N; i++){
        if (sieve[i]) continue;
        for (int j = 2 * i; j <= N; j += i){
            sieve[j] = 1;
        }
    }
    for (int i = 2; i <= N; i++){
        if (!sieve[i]) a[p++] = i;
    }
    
    while (true){
        if (sum >= N) sum -= a[lo++];
        else if (hi == p) break; 
        else sum += a[hi++];
        if (sum == N) ret++;
    }
    cout << ret << '\n';
    return 0;
}