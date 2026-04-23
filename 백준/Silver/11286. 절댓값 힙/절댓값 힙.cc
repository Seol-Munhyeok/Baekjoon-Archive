#include <bits/stdc++.h>
using namespace std;

class cmp {
    public:
    bool operator() (int a, int b){
        if (abs(a) != abs(b)) return abs(a) > abs(b);
        return a > 0 && b < 0;
    }
};

int n, x;
priority_queue<int, vector<int>, cmp> pq;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n;
    while (n--){
        cin >> x;
        if (x == 0){
            if (pq.empty()) cout << "0" << "\n";
            else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        }
        else pq.push(x);
    }

    return 0;
}