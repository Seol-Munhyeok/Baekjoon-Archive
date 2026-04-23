#include <bits/stdc++.h>
using namespace std;

vector<int> num;
vector<char> oper;
int N, ret = -1e9;
string s;

int calc(char a, int b, int c){
    if (a == '+') return b + c;
    if (a == '-') return b - c;
    if (a == '*') return b * c;
}

void go(int here, int psum){
    /*  here : 지금 처리하고 있는 계산 중 숫자의 시작 인덱스
        psum : 현재까지 계산된 누적합, 호출할 때부터 첫 번째 숫자로 호출함  */
    /* 함수가 하는 일 : here부터 시작해서 순방향으로 (괄호없이) 연산자 한 개를 처리해서 값 리턴
        또는 괄호가 있는 경우, 역방향으로 계산되는 결과를 처리해서 값 리턴 */
    if (here == num.size() - 1){
        ret = max(ret, psum);
        return;
    }
    
    /* 괄호없이 계산하는 경우 : 3 + 8 * 7 이라면 3 + 8만 처리하고 리턴한다. */
    go(here + 1, calc(oper[here], psum, num[here + 1]));

    /* 뒤 연산자에 괄호 넣고 계산하는 경우 : 3 + 8 * 7 이라면 8 * 7을 먼저계산하고 이를 3과 더하여 리턴한다. */
    if (here + 2 <= num.size() - 1){
        int temp = calc(oper[here + 1], num[here + 1], num[here + 2]);
        go(here + 2, calc(oper[here], psum, temp));
    }
    return;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    cin >> s;
    for (int i = 0; i < N; i++){
        if (i % 2 == 0) num.push_back(s[i] - '0');
        else oper.push_back(s[i]);
    }
    go(0, num[0]);
    cout << ret << '\n';
    return 0;
}