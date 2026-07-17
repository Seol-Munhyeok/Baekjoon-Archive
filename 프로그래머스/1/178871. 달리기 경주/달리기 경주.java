import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
          rank.put(players[i], i);  
        }
        for (String calling : callings) {
            int idx = rank.get(calling);
            String temp = players[idx - 1];
            players[idx - 1] = calling;
            players[idx] = temp;
            rank.put(calling, idx - 1);
            rank.put(temp, idx);   
        }
        return players;
    }
}