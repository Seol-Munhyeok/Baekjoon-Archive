import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static String next() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	static final int[] dy = {-1, 0, 1, 0};
	static final int[] dx = {0, 1, 0, -1};
	static int n;
	static int[][] arr, dp;
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
	
	static int go(int y, int x) {
		if (dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 1;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (inRange(ny, nx) && arr[y][x] < arr[ny][nx]) {
				dp[y][x] = Math.max(dp[y][x], go(ny, nx) + 1);
			}
		}
		
		return dp[y][x];
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = nextInt();
		arr = new int[n][n];
		dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = nextInt();
				dp[i][j] = -1;
			}
		}

		int maxAnswer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxAnswer = Math.max(maxAnswer, go(i, j));
			}
		}
		
		System.out.println(maxAnswer);
	}
}
