#include <bits/stdc++.h>
using namespace std;

int N, ret;
vector<int> v;
int main(){
    cin >> N;
    ret = 666;
    while (v.size() <= 10000){
        if (to_string(ret).find("666") != string::npos){
            v.push_back(ret);
        }
        ret++;
    }
    cout << v[N - 1];
    return 0;
}
    
