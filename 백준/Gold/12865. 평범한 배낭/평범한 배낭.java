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
		
		int N = nextInt();  // 물품의 수
		int K = nextInt();  // 최대 무게
		int[] W = new int[N];  // 물건 무게
		int[] V = new int[N];  // 물건 가치
		
		for (int i = 0; i < N; i++) {
			W[i] = nextInt();
			V[i] = nextInt();
		}
		
		int[][] dp = new int[N][K + 1];  // dp[i][j] = i번째 물건까지 고려했을 때 무게 j로 만들 수 있는 최대 가치
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (i > 0) {
					dp[i][j] = dp[i - 1][j];  // 물건 i를 넣지 않는 경우
				}
				if (j - W[i] >= 0) {  // 물건 i를 넣는 경우
					if (i > 0) {
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i]] + V[i]);
					} else {
						dp[i][j] = V[i];
					}
				}
			}
		}
		
		System.out.println(dp[N - 1][K]);
		
	}
}
