import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
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
	
	static final int[] dy = {-1, 0, 1, 0}; 
	static final int[] dx = {0, 1, 0, -1};
	static int N, M, K;
	static int[][] map;
	// [y][x][broken][day] = (y, x)에 broken 횟수로 벽을 부술 때 최단 거리.
	static int[][][] visited;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = nextInt(); M = nextInt(); K = nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		visited = new int[N][M][K + 1];  // 0 = 미방문
		
		Queue<int[]> q = new ArrayDeque<>();  // {y, x, broken, day}
		q.offer(new int[] {0, 0, 0, 0});
		visited[0][0][0] = 1;  // 시작 지점도 포함
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0], x = cur[1], brokenCnt = cur[2];
			int curDist = visited[y][x][brokenCnt];
			int day = curDist % 2; // 홀수(1)면 낮, 짝수(0)면 밤
			
			if (y == N - 1 && x == M - 1) {
				System.out.println(curDist);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d]; int nx = x + dx[d];
				
				if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
				
				if (map[ny][nx] == 0) {
					if (visited[ny][nx][brokenCnt] == 0) {
						q.offer(new int[] {ny, nx, brokenCnt});
						visited[ny][nx][brokenCnt] = curDist + 1;
					}
				}
				else if (map[ny][nx] == 1 && brokenCnt < K) {
					// 낮이면 벽 부수고 이동
					if (day == 1) {
						if (visited[ny][nx][brokenCnt + 1] == 0) {
							q.offer(new int[] {ny, nx, brokenCnt + 1});
							visited[ny][nx][brokenCnt + 1] = curDist + 1;
						}
					}
					// 밤이면 기다리기
					else {
						q.offer(new int[] {y, x, brokenCnt});
						visited[y][x][brokenCnt] = curDist + 1;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}