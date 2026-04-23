import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static final int INF = 1_000_000_000;
	static int N;
	static int[][] cost;
	static int[][] dp;
	
	static int tsp(int cur, int mask) {
		// Base case : 모든 도시 방문 완료
		if (mask == (1 << N) - 1) {
			// 시작점으로 돌아갈 수 없으면 불가능
			if (cost[cur][0] == 0) return INF;
			return cost[cur][0];
		}
		
		// 이미 계산한 상태면 재사용
		if (dp[cur][mask] != -1) return dp[cur][mask];
		
		dp[cur][mask] = INF;
		
		// 아직 방문하지 않은 도시를 하나씩 켜보는 과정
		for (int next = 0; next < N; next++) {
			// 이미 방문한 도시면 스킵
			if ((mask & (1 << next)) != 0) continue;
			
			// 길이 없으면 스킵
			if (cost[cur][next] == 0) continue;
			
			int nextMask = mask | (1 << next);
			
			dp[cur][mask] = Math.min(
					dp[cur][mask],
					tsp(next, nextMask) + cost[cur][next]
			);
			
		}
		
		return dp[cur][mask];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cost = new int[N][N];
		/*
		 * dp[cur][mask]
			= 현재 cur 도시에 있고,
  			     지금까지 mask에 표시된 도시들을 방문했을 때,
  			     남은 도시를 모두 방문한 뒤 시작점(0번)으로 돌아가는 최소 비용
		 */
		dp = new int[N][1 << N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(tsp(0, 1));
	}
}
