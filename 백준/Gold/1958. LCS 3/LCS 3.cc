#include <bits/stdc++.h>
using namespace std;

int lcs[102][102][102];
int p, q, r;
string A, B, C;

int main(){
    cin >> A >> B >> C;
    p = A.size();
    q = B.size();
    r = C.size();
    for (int i = 1; i <= p; i++){
        for (int j = 1; j <= q; j++){
            for (int k = 1; k <= r; k++){
                if (A[i - 1] == B[j - 1] && B[j - 1] == C[k - 1]) 
                    lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                else lcs[i][j][k] = max({lcs[i - 1][j][k], lcs[i][j - 1][k], lcs[i][j][k - 1]});
            }
        }
    }
    cout << lcs[p][q][r] << "\n";
    return 0;
}