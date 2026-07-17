import java.util.*;
class Solution {
    String[][] park;
    
    public int solution(int[] mats, String[][] park) {
        this.park = park;
        Arrays.sort(mats);
        int m = park.length;  // 세로
        int n = park[0].length;  // 가로
        
        for (int i = mats.length - 1; i >= 0; i--) {
            if (check(mats[i], m, n)) return mats[i];
        }
        
        return -1;
    }
    
    private boolean check(int len, int m, int n) {
        for (int i = 0; i < m - len + 1; i++) {
            for (int j = 0; j < n - len + 1; j++) {
                boolean canPlace = true;
                
                for (int dy = 0; dy < len; dy++) {
                    for (int dx = 0; dx < len; dx++) {
                        if (!park[i + dy][j + dx].equals("-1")) {
                            canPlace = false;
                        }
                    }
                    if (!canPlace) break;
                }
                if (canPlace) return true;
            }            
        }   
        return false;
    }
}