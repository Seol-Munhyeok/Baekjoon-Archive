class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for (char ch : s.toCharArray()) {
            answer += jump(ch, skip, index);
        }
        return answer;
    }
    
    private char jump(char ch, String skip, int index) {
        int jumpCount = 0;
        while (jumpCount < index) {
            char nextChar = (char)((ch - 'a' + 1) % 26 + 'a');
            if (skip.indexOf(nextChar) == -1) {
                jumpCount++;
            }    
            ch = nextChar;
        }
        return ch;
    }
}