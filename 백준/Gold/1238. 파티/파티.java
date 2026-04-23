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
		Edge(int to, int cost) { this.to = to; this.cost = cost; }
	}
	
	static class State {
		int node, dist;
		State(int node, int dist) { this.node = node; this.dist = dist; }
	}
	
	static final int INF = 2_000_000_000;
	static int V, E, X;
	static List<Edge>[] adj;
	static List<Edge>[] radj;  // 역그래프
	
	static int[] dijkstra(int start, List<Edge>[] graph) {
		int[] minDist = new int[V + 1];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
		pq.offer(new State(start, 0));
		
		while (!pq.isEmpty()) {
			State cur = pq.poll();
			if (cur.dist != minDist[cur.node]) continue;
			
			for (Edge edge : graph[cur.node]) {
				int nd = minDist[cur.node] + edge.cost;
				if (minDist[edge.to] > nd) {
					minDist[edge.to] = nd;
					pq.offer(new State(edge.to, nd));
				}
			}
		}
		
		return minDist;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		V = nextInt(); E = nextInt(); X = nextInt();
		
		adj = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		radj = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			radj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int a = nextInt(), b = nextInt(), w = nextInt();
			adj[a].add(new Edge(b, w));
			radj[b].add(new Edge(a, w));
		}
		
		int[] minDist = dijkstra(X, adj);
		int[] minDistR = dijkstra(X, radj);
		
		int maxAnswer = -INF;
		for (int i = 1; i <= V; i++) {
			maxAnswer = Math.max(maxAnswer, minDist[i] + minDistR[i]);
		}
		
		System.out.println(maxAnswer);
	}
}
