import java.util.*;
class Solution {
    
    char[][] park;
    Map<String, Integer> mp = Map.of("N", 0, "E", 1, "S", 2, "W", 3);
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        this.park = new char[n][m];
        for (int i = 0; i < n; i++) {
            this.park[i] = park[i].toCharArray();
        }
        
        int y = -1, x = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (this.park[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] cmd = route.split(" ");
            int cy = y, cx = x;
            boolean out = false;
            for (int dist = 0; dist < Integer.parseInt(cmd[1]); dist++) {
                cy += dy[mp.get(cmd[0])];
                cx += dx[mp.get(cmd[0])];
                if (cy < 0 || cy >= n || cx < 0 || cx >= m) { out = true; break; } 
                if (this.park[cy][cx] == 'X') { out = true; break; }
            }
            if (out) continue;
            y = cy; x = cx;
        }
        
        return new int[] {y, x};
    }
}