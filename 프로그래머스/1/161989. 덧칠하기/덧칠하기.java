class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0;
        while (idx < section.length) {
            int start = section[idx];
            while (idx < section.length && section[idx] <= start + m - 1) {
                idx++;
            }
            answer++;
        }
        return answer;
    }
}