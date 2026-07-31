import java.util.*;
class Solution {
    Map<String, Integer> mp = new HashMap<>();
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        for (int i = 0; i < name.length; i++) {
            mp.put(name[i], yearning[i]);
        }
        int n = photo.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = getResult(photo[i]);
        }
        return answer;
    }
    
    private int getResult(String[] p) {
        int result = 0;
        for (String name : p) {
            result += mp.getOrDefault(name, 0);
        }
        return result;
    }
}