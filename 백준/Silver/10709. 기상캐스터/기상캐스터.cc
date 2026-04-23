#include <bits/stdc++.h>
using namespace std;

char a[103][103];
int b[103][103];
int H, W, ret;
string s;
bool flag;

int main(){
    cin >> H >> W;
    for (int i = 0; i < H; i++){
        for (int j = 0; j < W; j++){
            cin >> a[i][j];
        }
    }
    for (int i = 0; i < H; i++){
        flag = 0; ret = 1;
        for (int j = 0; j < W; j++){
            if (a[i][j] == '.'){
                if (flag == 0) b[i][j] = -1;
                if (flag == 1) b[i][j] = ret++;
            }
            if (a[i][j] == 'c') {
                flag = 1; b[i][j] = 0; ret = 1;
            }
        }
    }
    for (int i = 0; i < H; i++){
        for (int j = 0; j < W; j++){
            cout << b[i][j] << ' ';
        }
        cout << '\n';
    }
    return 0;
}