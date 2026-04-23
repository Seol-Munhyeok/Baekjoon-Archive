import java.io.*;
import java.util.*;

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
	
	static int N, minAnswer, population[];
	static List<Integer>[] adj;
	static boolean isSelected[], visited[];
	
	static int bfs(int u) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(u);
		visited[u] = true;
		
		int visitedCnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			visitedCnt++;
			for (int next : adj[cur]) {
				if (visited[next]) continue;
				if (isSelected[cur] != isSelected[next]) continue;
				q.offer(next);
				visited[next] = true;
			}
		}
		
		return visitedCnt;
	}
	
	// 선거구를 나눌 수 있는지 확인
	static boolean check() {
		Arrays.fill(visited, false);
		
		int aCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) aCnt++;
		}
		
		if (aCnt == 0 || aCnt == N) return false;
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && isSelected[i]) {
				count += bfs(i);
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && !isSelected[i]) {
				count += bfs(i);
				break;
			}
		}
		
		return count == N;
	}
	
	static int getDiff() {
		int aSum = 0, bSum = 0;
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) aSum += population[i];
			else bSum += population[i];
		}
		return Math.abs(aSum - bSum);
	}
	
	static void dfs(int index) {
		if (index == N + 1) {
			if (check()) minAnswer = Math.min(minAnswer, getDiff());
			return;
		}
		
		isSelected[index] = true;
		dfs(index + 1);
		
		isSelected[index] = false;
		dfs(index + 1);
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
	
		N = nextInt();
		population = new int[N + 1]; // 1-based
		isSelected = new boolean[N + 1];  // 1-based
		visited = new boolean[N + 1];  // 1-based
		adj = new List[N + 1];  // 1-based
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) population[i] = nextInt();
		
		for (int u = 1; u <= N; u++) {
			int m = nextInt();
			for (int i = 0; i < m; i++) {
				int v = nextInt();
				adj[u].add(v);
			}
		}
		
		minAnswer = 1_000_000_000;
		isSelected[1] = true;  // 대칭 분할(보완 탐색)
		dfs(2);
		
		minAnswer = (minAnswer == 1_000_000_000) ? -1 : minAnswer;
		System.out.println(minAnswer);
	}
}
