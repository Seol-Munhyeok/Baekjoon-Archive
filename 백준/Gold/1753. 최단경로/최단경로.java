import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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
	
	static class Edge {
		int to, cost;
		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static final int INF = 2_000_000_000;
	static int V, E;
	static int K;  // 시작점
	static int[] minDist;
	static List<Edge>[] adj;
	
	static void dijkstra() {
		minDist = new int[V + 1];
		Arrays.fill(minDist, INF);
		minDist[K] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.offer(new int[] {K, 0});  // {정점 번호, 가중치}
		
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int v = cur[0], w = cur[1];
			if (w != minDist[v]) continue;
			
			for (Edge edge : adj[v]) {
				int nd = minDist[v] + edge.cost;
				if (nd < minDist[edge.to]) {
					minDist[edge.to] = nd;
					pq.offer(new int[] {edge.to, nd});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		V = nextInt(); E = nextInt();
		K = nextInt();
		adj = new List[V + 1];
		for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			int u = nextInt(), v = nextInt(), w = nextInt();
			adj[u].add(new Edge(v, w));
		}
		
		dijkstra();
		for (int i = 1; i <= V; i++) {
			sb.append(minDist[i] != INF ? minDist[i] : "INF").append("\n");
		}
		System.out.println(sb);
	}
}
