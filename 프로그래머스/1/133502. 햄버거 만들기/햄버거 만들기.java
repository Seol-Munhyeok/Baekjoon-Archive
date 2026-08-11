import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < ingredient.length; i++) {
            stk.push(ingredient[i]);
            if (stk.peek() == 1) {
                Deque<Integer> temp = new ArrayDeque<>();
                boolean found = true;
                temp.push(stk.pop());
                for (int j = 3; j > 0; j--) {
                    if (!stk.isEmpty() && stk.peek() == j) {
                        temp.push(stk.pop());
                    } else {
                        found = false;
                        break;   
                    }
                }
                if (found) answer++;
                else {
                    while (!temp.isEmpty()) {
                        stk.push(temp.pop());
                    }
                }
            }
        }
        
        return answer;
    }
}