#include <bits/stdc++.h>
using namespace std;

int n, digit;
long long num;

int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    while (cin >> n){
        digit = 1;
        num = 1;
        while (true){
            if (num % n == 0) {
                cout << digit << '\n';
                break;
            }
            
            num = num * 10 + 1;
            num %= n;
            digit++;
            
        }
    }
    return 0;
}