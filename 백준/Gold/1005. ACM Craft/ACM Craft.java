import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
	
	static int N, K, W;
	static int[] buildTime, dp, indegree;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = nextInt();  // 건물의 개수
			K = nextInt();  // 건설순서 규칙 개수
			buildTime = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				buildTime[i] = nextInt();
			}
			
			adj = new List[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			indegree = new int[N + 1];
			for (int i = 0; i < K; i++) {
				int x = nextInt();
				int y = nextInt();
				adj[x].add(y);  // 정방향
				indegree[y]++;
			}
			
			W = nextInt();  // 건설해야 할 건물 번호
			
			dp = new int[N + 1];  // dp[i] = i 건물을 세우는데 필요한 최소 시간
			Queue<Integer> q = new ArrayDeque<>();
			
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					dp[i] = buildTime[i];
					q.offer(i);
				}
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (int next : adj[cur]) {
					dp[next] = Math.max(dp[next], dp[cur] + buildTime[next]);
					indegree[next]--;
					
					if (indegree[next] == 0) {
						q.offer(next);
					}
				}
			}
			sb.append(dp[W]).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
