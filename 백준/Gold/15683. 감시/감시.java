import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	static class CCTV {
		int id, y, x;
		CCTV (int id, int y, int x) { this.id = id; this.y = y; this.x = x; }
	}
	
	static int N, M, minAnswer;
    static int[][] arr;
    static List<CCTV> cctvs = new ArrayList<>();
	
    // 우, 하, 좌, 상
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    
    // CCTV 타입별 가능한 방향 경우의 수
    static final int[][][] DIRS = {
    		{},
    		{{0}, {1}, {2}, {3}},  						  // 1번
    		{{0, 2}, {1, 3}},							  // 2번
    		{{3, 0}, {0, 1}, {1, 2}, {2, 3}},			  // 3번
    		{{2, 3, 0}, {3, 0, 1}, {0, 1, 2}, {1, 2, 3}}, // 4번
    	    {{0, 1, 2, 3}}								  // 5번
    };
    
    // 한 방향으로 감시
    // 이번 호출에서 새롭게 0 -> -1로 바뀐 칸만 changed에 기록
    static void watchLine(int y, int x, int dir, List<int[]> changed) {
    	int ny = y + dy[dir];
    	int nx = x + dx[dir];
    	
    	while (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] != 6) {
    		if (arr[ny][nx] == 0) {
    			arr[ny][nx] = -1;
    			changed.add(new int[] {ny, nx});
    		}
    		ny += dy[dir];
    		nx += dx[dir];
    	}
    }
    
    // CCTV 하나의 여러 방향 감시
    static void watch(CCTV cctv, int[] dirs, List<int[]> changed) {
    	for (int dir : dirs) {
    		watchLine(cctv.y, cctv.x, dir, changed);
    	}
    }
	
    // 이번 단계에서 바뀐 칸만 복구
    static void undo(List<int[]> changed) {
    	for (int[] pos : changed) {
    		arr[pos[0]][pos[1]] = 0;
    	}
    }
    
    static int countBlind() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    
    static void dfs(int idx) {
    	if (idx == cctvs.size()) {
    		minAnswer = Math.min(minAnswer, countBlind());
    		return;
    	}
    	
    	CCTV cur = cctvs.get(idx);
    	
    	for (int[] dirs : DIRS[cur.id]) {
    		List<int[]> changed = new ArrayList<>();
    		
    		watch(cur, dirs, changed);
    		dfs(idx + 1);
    		undo(changed);
    	}
    }
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = nextInt(); M = nextInt();
		arr = new int[N][M];
		cctvs = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = nextInt();
                if (1 <= arr[i][j] && arr[i][j] <= 5) {
                    cctvs.add(new CCTV(arr[i][j], i, j));
                }
			}
		}
		
		minAnswer = 1_000_000_000;
		dfs(0);
		System.out.println(minAnswer);
	}
}
