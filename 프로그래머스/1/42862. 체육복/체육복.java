import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int uniformCount = 0;
        // 여벌을 가져온 학생이 도난당한 경우 고려
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    uniformCount++;
                    break;
                }
            }
        }
           
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    uniformCount++;
                    reserve[j] = -1;
                    break;
                } 
            }
        }
        
        return n - lost.length + uniformCount;
    }
}