#include <bits/stdc++.h>
#define time aaaa
using namespace std;

int N, team, winningTeam, goalTime = -1;
string time;
int score[3], winningTime[3];

int winner(){
    if (score[1] > score[2]) return 1;
    else if (score[1] < score[2]) return 2;
    else return 0;
}

int convert(string s){
    return stoi(s.substr(0, 2)) * 60 + stoi(s.substr(3));
}

int main(){
    cin >> N;
    while (N--){
        winningTeam = winner();
        cin >> team >> time;
        score[team]++;

        if (winner() == 0){
                winningTime[winningTeam] += (convert(time) - goalTime);
                goalTime = -1; winningTeam = 0;
        }
        else if (goalTime == -1) {
            winningTeam = winner();
            goalTime = convert(time);
        }
    }
    winningTime[winningTeam] += (convert("48:00") - goalTime);

    for (int i = 1; i <= 2; i++)
        printf("%02d:%02d\n", winningTime[i] / 60, winningTime[i] % 60);
    
    return 0;
}