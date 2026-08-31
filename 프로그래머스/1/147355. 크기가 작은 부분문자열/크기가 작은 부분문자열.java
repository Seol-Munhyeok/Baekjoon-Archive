class Solution {
    public int solution(String t, String p) {
        int n = p.length();
        long num = Long.parseLong(p);
        int answer = 0;
        for (int i = 0; i < t.length() - n + 1; i++) {
            long temp = Long.parseLong(t.substring(i, i + n));
            if (temp <= num) {
                answer++;
            }
        }
        
        return answer;
    }
}