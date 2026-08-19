class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                int t = size[1];
                size[1] = size[0];
                size[0] = t;
            }
        }
        int a = 0, b = 0;
        for (int[] size : sizes) {
            a = Math.max(a, size[0]);
            b = Math.max(b, size[1]);
        }

        return a * b;
    }
}