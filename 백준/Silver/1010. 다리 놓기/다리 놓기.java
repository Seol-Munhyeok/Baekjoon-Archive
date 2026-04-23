import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
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
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = nextInt(), M = nextInt();
			long dp[][] = new long[31][31];
			
			for (int n = 0; n <= 30; n++) {
				dp[n][0] = 1;
				dp[n][n] = 1;
			}
			
			for (int n = 1; n <= 30; n++) {
				for (int r = 1; r < n; r++) {
					dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
				}
			}
			
			sb.append(dp[M][N]).append("\n");
		}
		
		System.out.println(sb);
	}
}
