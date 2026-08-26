import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = score.length;
        int[] answer = new int[n];
        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(score[i]);
            answer[i] = pq.peek();
        }
        for (int i = k; i < n; i++) {
            if (pq.peek() < score[i]) {
                pq.poll();
                pq.offer(score[i]);
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}