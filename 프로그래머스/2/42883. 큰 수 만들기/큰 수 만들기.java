import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Deque<Integer> stk = new ArrayDeque<>();
        int popCount = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            while (popCount < k && !stk.isEmpty() && stk.peek() < num) {
                stk.pop();
                popCount++;
            }
            
            stk.push(num);
        }
        
        while (popCount < k) {
            stk.pop();
            popCount++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        
        return sb.reverse().toString();
    }
}