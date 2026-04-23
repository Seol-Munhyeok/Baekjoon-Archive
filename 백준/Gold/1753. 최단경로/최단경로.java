import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 메모리 : 
 * 시간 : 
 */
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
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
		pq.offer(new long[] {start, 0});  // {정점 번호, 시작점으로부터 현재 거리}
		
		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			int u = (int) cur[0];
			long dist = cur[1];
			
			// 이미 더 짧은 거리로 갱신된 적 있으면 버림
			if (dist != minDist[u]) continue;
			
			for (int[] edge : adj[u]) {
				int next = edge[0];
				int w = edge[1];
				
				long nd = dist + w;
				if (nd < minDist[next]) {
					minDist[next] = nd;
					pq.offer(new long[] {next, nd});
				}
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
