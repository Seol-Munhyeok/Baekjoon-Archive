import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<List<Integer>> seq = new ArrayList<>();
        seq.add(List.of(1, 2, 3, 4, 5));
        seq.add(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        seq.add(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        
        int[] correct = new int[3];
        for (int i = 0; i < 3; i++) {
            int seqLen = seq.get(i).size();
            int correctCount = 0;
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == seq.get(i).get(j % seqLen)) {
                    correctCount++;
                }
            }
            correct[i] = correctCount;
        }
        
        // 정답 구하기
        List<Integer> resultList = new ArrayList<>();
        int mx = 0;
        for (int i = 0; i < 3; i++) {
            mx = Math.max(correct[i], mx);
        }
        for (int i = 0; i < 3; i++) {
            if (correct[i] == mx) {
                resultList.add(i + 1);
            }
        }
        
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}