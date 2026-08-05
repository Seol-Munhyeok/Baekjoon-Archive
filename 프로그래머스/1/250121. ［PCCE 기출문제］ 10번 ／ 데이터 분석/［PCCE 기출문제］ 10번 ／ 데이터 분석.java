import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = Map.of(
            "code", 0,
            "date", 1,
            "maximum", 2,
            "remain", 3
        );
        
        List<int[]> lst = new ArrayList<>();
        for (int[] d : data) {
            if (d[map.get(ext)] < val_ext) {
                lst.add(d);
            }
        }
        
        lst.sort(Comparator.comparingInt(d -> d[map.get(sort_by)]));
        int[][] answer = lst.toArray(new int[0][]);
        
        return answer;
    }
}