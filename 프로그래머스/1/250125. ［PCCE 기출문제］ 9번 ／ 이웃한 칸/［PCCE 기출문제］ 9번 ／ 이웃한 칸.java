class Solution {
    
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, 1, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        
        for (int d = 0; d < 4; d++) {
            int nh = h + dy[d];
            int nw = w + dx[d];
            if (nh < 0 || nh >= n || nw < 0 || nw >= m) continue;
            if (board[nh][nw].equals(board[h][w])) {
                answer++;
            }
        }
        return answer;
    }
}