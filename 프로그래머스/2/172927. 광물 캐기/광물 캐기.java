import java.util.*;

class Solution {
    
    int answer, n;
    int[] picks, usedTool;
    String[] minerals;
    int[][] table = { {1, 1, 1}, {5, 1, 1}, {25, 5, 1} };
    List<Integer> toolOrder;
    Map<String, Integer> mapper = new HashMap<>(Map.of("diamond", 0, "iron", 1, "stone", 2));
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        answer = Integer.MAX_VALUE;
        toolOrder = new ArrayList<>();
        usedTool = new int[3];
        
        // n = 최소 곡괭이 사용 횟수
        n = Math.min(
            (int) Math.ceil(minerals.length / 5.0),
            picks[0] + picks[1] + picks[2]
        );
        dfs(0);
        return answer;
    }
    
    private void dfs(int idx) {
        if (idx == n) {
            answer = Math.min(answer, getValue());
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (usedTool[i] >= picks[i]) continue;
            
            toolOrder.add(i);
            usedTool[i]++;
            
            dfs(idx + 1);
            
            toolOrder.remove(toolOrder.size() - 1);
            usedTool[i]--;
        }
    }
    
    private int getValue() {
        int result = 0;
        List<Integer> order = new ArrayList<>();
               
        for (int tool : toolOrder) {
            for (int i = 0; i < 5; i++) {
                order.add(tool);
            }
        }
        
        int n = Math.min(order.size(), minerals.length);
        for (int i = 0; i < n; i++) {
            result += table[order.get(i)][mapper.get(minerals[i])];
        }        
        
        return result;
    }
}