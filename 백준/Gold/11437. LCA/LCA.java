import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int N;
	static List<Integer>[] adj;
	static int[] depth;  	   // 루트로부터 깊이
	static boolean[] visited;  // 각 노드의 깊이가 계산되었는지 여부
	static int[] parent;       // parent[v] = v의 조상
	
	// 루트 노드부터 시작하여 깊이를 구하는 함수
	static void dfs(int x, int dep) {
		visited[x] = true;
		depth[x] = dep;
		
		for (int y : adj[x]) {
			if (visited[y]) continue;
			parent[y] = x;
			dfs(y, dep + 1);
		}
	}
	
	static int lca(int a, int b) {
		// 1) 깊이 맞추기: 더 깊은 쪽을 위로 올림
	    while (depth[a] > depth[b]) a = parent[a];
	    while (depth[b] > depth[a]) b = parent[b];
	    
	    // 2) 같이 올라가서 만나는 지점이 LCA
	    while (a != b) {
	    	a = parent[a];
	    	b = parent[b];
	    }
	    return a;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = nextInt();
		adj = new List[N + 1];
		for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		depth = new int[N + 1];
		parent = new int[N + 1];
		
		for (int r = 0; r < N - 1; r++) {
			int u = nextInt(); int v = nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(1, 0); // 트리 부모 관계 및 깊이 저장, 루트 노드는 1번 노드
		
		int M = nextInt();
		for (int r = 0; r < M; r++) {
			int a = nextInt(); int b = nextInt();
			sb.append(lca(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}
}
