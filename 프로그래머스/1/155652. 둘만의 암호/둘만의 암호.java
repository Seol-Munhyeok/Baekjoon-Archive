import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        Set<Character> skipSet = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        
        for (char ch : s.toCharArray()) {
            answer.append(jump(ch, skipSet, index));
        }
        return answer.toString();
    }
    
    private char jump(char ch, Set<Character> skipSet, int index) {
        int jumpCount = 0;
        while (jumpCount < index) {
            ch = (char)((ch - 'a' + 1) % 26 + 'a');
            if (!skipSet.contains(ch)) {
                jumpCount++;
            }    
        }
        return ch;
    }
}