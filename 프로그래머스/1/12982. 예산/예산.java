import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0, price = 0;
        for (int i = 0; i < d.length; i++) {
            price += d[i];
            if (price > budget) return answer;
            answer++;
        }
        return answer;
    }
}