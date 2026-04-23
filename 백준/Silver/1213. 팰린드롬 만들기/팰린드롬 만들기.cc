#include <bits/stdc++.h>
using namespace std;
string s, ret;
int cnt[200], flag;
char mid;
int main(){
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> s;
    for (char ch : s) cnt[ch]++;
    for (int i = 'Z'; i >= 'A'; i--){
        if (cnt[i]){
            if (cnt[i] & 1) {
                // cnt[i]가 홀수인 경우
                mid = char(i); flag++;  // 가운데 삽입할 문자를 따로 뽑는다.
                cnt[i]--;
            }
            if (flag == 2) break;  // 홀수가 두 개이상이면 만들 수 없다.
            for (int j = 0; j < cnt[i]; j += 2){
                ret = char(i) + ret;  // 원래 문자열 앞에 붙이고
                ret += char(i);  // 원래 문자열 뒤에도 붙인다.
            }
        }
    }
    // mid가 존재하면 만든 문자열 가운데에 mid를 삽입한다.
    if (mid) ret.insert(ret.begin() + ret.size() / 2, mid);
    if (flag == 2) cout << "I'm Sorry Hansoo\n";
    else cout << ret << '\n';
    
    return 0;
}