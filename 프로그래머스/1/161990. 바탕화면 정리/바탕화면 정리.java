class Solution {
    public int[] solution(String[] wallpaper) {
        final int INF = 1_000_000_000;
        int minY = INF, maxY = -INF, minX = INF, maxX = -INF;
        int n = wallpaper.length, m = wallpaper[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minY = Math.min(minY, i);
                    maxY = Math.max(maxY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                }
            }
        }

        return new int[] {minY, minX, maxY + 1, maxX + 1};
    }
}