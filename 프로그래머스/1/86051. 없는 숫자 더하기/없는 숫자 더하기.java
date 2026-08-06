class Solution {
    public int solution(int[] numbers) {
        boolean[] b = new boolean[10];
        for (int num : numbers) {
            b[num] = true;
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (!b[i]) {
                answer += i;
            }
        }
        return answer;
    }
}