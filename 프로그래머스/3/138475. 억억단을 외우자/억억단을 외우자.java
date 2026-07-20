import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        // count[i] = i의 약수의 개수
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                count[j]++;
            }
        }

        // [x, e] 구간에서 가장 많이 등장하는 횟수 저장
        int maxScore = count[e];
        int bestAns = e;
        int[] best = new int[e + 1];
        for (int x = e; x >= 1; x--) {
            if (count[x] >= maxScore) {
                maxScore = count[x];
                bestAns = x;
            }
            best[x] = bestAns;
        }
        
        // 정답 출력
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = best[starts[i]];
        }
        return answer;
    }
}