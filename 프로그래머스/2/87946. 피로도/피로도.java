import java.util.*;
class Solution {
    
    int N, k, answer;
    int[][] dungeons;
    boolean[] visited;
    List<Integer> visitOrder;
    
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        N = dungeons.length;
        visited = new boolean[N];
        visitOrder = new ArrayList<>();
        answer = -1;
        dfs(0);
        return answer;
    }
    
    private void dfs(int depth) {
        if (depth == N) {
            answer = Math.max(answer, getMaxDungeon());
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            
            visitOrder.add(i);
            visited[i] = true;
            
            dfs(depth + 1);
            
            visitOrder.remove(visitOrder.size() - 1);
            visited[i] = false;
        }
    }
    
    private int getMaxDungeon() {
        int curK = k;
        int visitCount = 0;
        for (int idx : visitOrder) {
            if (curK < dungeons[idx][0]) {
                return visitCount;
            }
            curK -= dungeons[idx][1];
            visitCount++;
        }
        return visitCount;
    }
}