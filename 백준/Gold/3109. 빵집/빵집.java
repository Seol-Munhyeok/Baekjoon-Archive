import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	static final int[] dy = {-1, 0, 1};  // 위쪽 부터 먼저 탐색
	static int R, C, answer;
	static char[][] arr;
	
	static boolean dfs(int y, int x) {
		if (x == C - 1) return true;
		
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + 1;
			
			if (ny < 0 || ny >= R || nx >= C) continue;
			if (arr[ny][nx] != '.') continue;
			
			arr[ny][nx] = 'x';  // 방문 처리
			if (dfs(ny, nx)) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		R = nextInt();
		C = nextInt();
		arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		answer = 0;
		for (int i = 0; i < R; i++) {
			arr[i][0] = 'x';  // 출발지 방문 처리
			if (dfs(i, 0)) answer++;
		}
		
		System.out.println(answer);
	}
}
