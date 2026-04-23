import java.io.*;
import java.util.*;

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
		int to, w;
		boolean removed;
		Edge(int to, int w) { this.to = to; this.w = w; }
	}
	
	static class State {
		int node, dist;
		State(int node, int dist) { this.node = node; this.dist = dist; }
	}
	
	static final int INF = 2_000_000_000;
	static int V, E, S, D;
	static List<Edge>[] adj, radj;
	
	static void solve(int dst, int[] dist) {
		// 역그래프를 BFS 하며 최단 경로에 속한 간선을 삭제
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(dst);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Edge edge : radj[cur]) {
				if (edge.removed) continue;
				// 최단 경로에 속한 간선이면 삭제
				if (dist[edge.to] + edge.w == dist[cur]) {
					edge.removed = true;
					q.offer(edge.to);
				}
			}
		}
	}
	
	static int[] dijkstra(int start, List<Edge>[] graph) {
		int[] minDist = new int[V];
		Arrays.fill(minDist, INF);
		minDist[start] = 0;
		
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
		pq.offer(new State(start, 0));
		
		while (!pq.isEmpty()) {
			State cur = pq.poll();
			if (cur.dist != minDist[cur.node]) continue;
			
			for (Edge edge : graph[cur.node]) {
				if (edge.removed) continue;
				
				int nd = minDist[cur.node] + edge.w;
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
		sb = new StringBuilder();
		
		while (true) {
			V = nextInt(); E = nextInt();
			if (V == 0 && E == 0) break;
			adj = new List[V];    // 0-based
			for (int i = 0; i < V; i++) {
				adj[i] = new ArrayList<>();
			}
			radj = new List[V];
			for (int i = 0; i < V; i++) {
				radj[i] = new ArrayList<>();
			}
			
			S = nextInt(); D = nextInt();
			for (int i = 0; i < E; i++) {
				int u = nextInt(), v = nextInt(), p = nextInt();
				adj[u].add(new Edge(v, p));
				radj[v].add(new Edge(u, p));  // 역그래프
			}
			
			int[] dist = dijkstra(S, adj);
			solve(D, dist);
			int[] almostMinDist = dijkstra(D, radj);
			sb.append(almostMinDist[S] == INF ? -1 : almostMinDist[S]).append("\n");
		}
		
		System.out.println(sb);
	}
}
