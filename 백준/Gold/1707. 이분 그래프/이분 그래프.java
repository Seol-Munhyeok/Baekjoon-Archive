import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
	
	public static boolean isBipartite(ArrayList<Integer>[] graph, int V) {
		int[] color = new int[V + 1];  // 0=uncolored, 1 or -1
		
		for (int s = 1; s <= V; s++) {
			if (color[s] != 0) continue;
			
			Queue<Integer> q = new ArrayDeque<>();
			q.add(s);
			color[s] = 1;
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : graph[cur]) {
					// 이미 색이 칠해져 있으면: 충돌만 검사
					if (color[next] != 0) {
						if (color[next] == color[cur]) return false;
						continue;
					}
					// 아직 색이 없으면: 반대색으로 칠하고 큐에 넣기
					color[next] = -color[cur];
					q.add(next);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		 
		int K = nextInt();
		 
		for (int tc = 1; tc <= K; tc++) {
			 
			// 그래프 입력 처리
			int V = nextInt();
			int E = nextInt();
			ArrayList<Integer>[] graph = new ArrayList[V + 1];
			
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				int u = nextInt();
				int v = nextInt();
				graph[u].add(v);
				graph[v].add(u);
			}
			
			// 정답 판정
			String answer = isBipartite(graph, V) ? "YES" : "NO";
			sb.append(answer).append('\n');
		}
		 
		System.out.print(sb);
  }
}
