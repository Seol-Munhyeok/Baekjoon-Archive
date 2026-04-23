import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = nextInt();
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];  // dp[i][j] = i번째 집까지 고려할 때 그 집을 j로 칠했을 때의 최소 비용
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = nextInt();
			}
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + cost[i][j];
			}
		}
		
		int minAnswer = 1_000_000_000;
		for (int i = 0; i < 3; i++) {
			minAnswer = Math.min(minAnswer, dp[n - 1][i]);
		}
		
		System.out.println(minAnswer);
	}
}
