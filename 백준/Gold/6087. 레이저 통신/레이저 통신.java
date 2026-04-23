import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
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
	static int W, H;
	static List<int[]> lasers;
	static char[][] map;
	static int[][][] dist;  // dist[y][x][dir] = 꺾은 횟수, -1 (미방문)
	
	static int bfs(int sy, int sx, int ey, int ex) {
		Deque<int[]> dq = new ArrayDeque<>();
		for (int d = 0; d < 4; d++) {
			dq.offerLast(new int[] {sy, sx, d});
			dist[sy][sx][d] = 0;
		}
		
		while (!dq.isEmpty()) {
			int[] cur = dq.pollFirst();
			int y = cur[0], x = cur[1], curDir = cur[2];
			
			if (y == ey && x == ex) return dist[y][x][curDir];
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir], nx = x + dx[dir];
				int nd = dist[y][x][curDir] + ((curDir != dir) ? 1 : 0);
				
				if (ny >= H || ny < 0 || nx >= W || nx < 0) continue;
				if (map[ny][nx] == '*') continue;
				
				if (dist[ny][nx][dir] == -1 || dist[ny][nx][dir] > nd) {
					dist[ny][nx][dir] = nd;
					if (curDir == dir) dq.offerFirst(new int[] {ny, nx, dir});
					else dq.offerLast(new int[] {ny, nx, dir});
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		W = nextInt(); H = nextInt();
		map = new char[H][W];
		lasers = new ArrayList<>();
		
		// map 입력 처리
		for (int i = 0; i < H; i++) {
			String line = next();
			for (int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'C') {
					lasers.add(new int[] {i, j});
				}
			}
		}
		
		// dist 초기화
		dist = new int[H][W][4];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(dist[i][j], -1);
			}
		}
		
		int sy = lasers.get(0)[0];
		int sx = lasers.get(0)[1];
		int ey = lasers.get(1)[0];
		int ex = lasers.get(1)[1];
		
		int answer = bfs(sy, sx, ey, ex);
		
		System.out.println(answer);
	}
}
