import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	static final long INF = Long.MAX_VALUE / 4;
	static int V, E, K;
	static List<int[]>[] adj;  // {v, w}
	static long[] minDist;
	static boolean[] visited;
	
	static void dijkstra(int start) {
		minDist = new long[V + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		visited = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) {
			int u = -1;
			long min = INF;
			
			// 1) 방문 안 한 정점 중 dist가 가장 작은 정점 선택
			for (int v = 1; v <= V; v++) {
				if (!visited[v] && min > minDist[v]) {
					min = minDist[v];
					u = v;
				}
			}
			
			if (u == -1) break;
			visited[u] = true;
			
			// 2) 최소값 갱신
			for (int[] edge : adj[u]) {
				int next = edge[0], w = edge[1];
				long nd = minDist[u] + w;
				if (nd < minDist[next]) minDist[next] = nd;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		V = nextInt(); E = nextInt();
		K = nextInt();  // 시작 정점의 번호 (1-based)
		
		adj = new List[V + 1];
		for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
		
		for (int r = 0; r < E; r++) {
			int u = nextInt(), v = nextInt(), w = nextInt();
			adj[u].add(new int[] {v, w});
		}
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			sb.append(minDist[i] == INF ? "INF" : minDist[i]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
