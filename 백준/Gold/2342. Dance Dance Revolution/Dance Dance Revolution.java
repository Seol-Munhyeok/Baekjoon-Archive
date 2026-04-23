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
	
	static final int INF = 1_000_000_000;
	static final int MAX = 100_001;
	
	static int cost(int from, int to) {
		if (from == to) return 1;
		if (from == 0) return 2;
		if (Math.abs(from - to) == 2) return 4;
		return 3;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[MAX];  // 1-based
		int N = 0;
		
		while (true) {
			int num = nextInt();
			if (num == 0) break;
			arr[++N] = num;
		}
		
		// dp[l][r] = 지금까지 i번째 지시까지 처리했을 때, 두 발 위치가 (l, r)인 최소 누적 힘
		int[][] dp = new int[5][5];   
		for (int i = 0; i < 5; i++) Arrays.fill(dp[i], INF);
		dp[0][0] = 0;
		
		for (int idx = 1; idx <= N; idx++) {
			int target = arr[idx];
			int[][] next = new int[5][5];
			for (int i = 0; i < 5; i++) Arrays.fill(next[i], INF);
			
			for (int l = 0; l < 5; l++) {
				for (int r = 0; r < 5; r++) {
					int cur = dp[l][r];
					
					// 왼발로 이동 (오른발과 같으면 안됨)
					if (target != r) {
						next[target][r] = Math.min(next[target][r], cost(l, target) + cur);
					}
					// 오른발로 이동
					if (target != l) {
						next[l][target] = Math.min(next[l][target], cost(r, target) + cur);
					}
				}
			}
			
			dp = next;
		}
		
		int answer = INF;
		for (int l = 0; l < 5; l++) {
	        for (int r = 0; r < 5; r++) {
	            answer = Math.min(answer, dp[l][r]);
	        }
	    }
		
		System.out.println(answer);
	}
}