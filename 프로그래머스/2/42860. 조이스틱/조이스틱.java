import java.util.*;
class Solution {
    public int solution(String name) {
        // 위, 아래 이동 횟수
        int n = name.length();
        int[] moveCount = new int[n];
        for (int i = 0; i < n; i++) {
            int up = name.charAt(i) - 'A';
            moveCount[i] = Math.min(up, 26 - up);
        }
        
        // 좌우 이동 횟수
        int minMove = n - 1;
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            minMove = Math.min(minMove, Math.min(2 * i + n - next, 2 * (n - next) + i));
        }
        
        // 정답 계산
        int answer = minMove;
        for (int i = 0; i < n; i++) {
            answer += moveCount[i];
        }
        return answer;
    }
    
    
}