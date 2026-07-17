// yellow 두 수의 곱 모든 경우의 수 확인

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= (int)Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                if (check(yellow / i, i) == brown) {
                    answer[0] = 2 + yellow / i;
                    answer[1] = 2 + i;
                    break;
                }
            }
        }
        return answer;
    }
    
    private int check(int w, int h) {
        return (w + h + 2) * 2;
    }
    
}