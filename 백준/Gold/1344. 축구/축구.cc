#include <bits/stdc++.h>
using namespace std;
const int N = 19;
vector<int> range = {0,1,4,6,8,9,10,12,14,15,16,18};
int C[] = {1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1};
int main(){
    double a, b;
    cin >> a >> b;
    a /= 100;  b /= 100;
    double Sa = 0, Sb = 0;
    for (int r : range){
        Sa += C[r] * pow(a, r) * pow(1 - a, N - 1 - r);
        Sb += C[r] * pow(b, r) * pow(1 - b, N - 1 - r);
    }
    cout << 1 - Sa * Sb << "\n";
    return 0;
}