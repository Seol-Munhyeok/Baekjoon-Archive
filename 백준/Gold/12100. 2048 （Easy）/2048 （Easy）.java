import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	
	static int N, maxBlock, map[][], temp[][];
	
	static void clearTemp() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(temp[i], 0);
		}
	}
	
	static void deepCopyMap() {
		for (int i = 0; i < N; i++) {
			map[i] = temp[i].clone(); 
		} 
	}
	
	static void push(int dir) {
		clearTemp();
		
		if (dir == 0) {  // 오른쪽 이동
			for (int i = 0; i < N; i++) {
				int endOfArray = N - 1;
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						temp[i][endOfArray--] = map[i][j];
					}
				}
			}
			deepCopyMap();
		}
		
		else if (dir == 1) {  // 왼쪽 이동
			for (int i = 0; i < N; i++) {
				int endOfArray = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						temp[i][endOfArray++] = map[i][j];
					}
				}
			}
			deepCopyMap();
		}
		
		else if (dir == 2) {  // 위쪽 이동
			for (int i = 0; i < N; i++) {
				int endOfArray = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] != 0) {
						temp[endOfArray++][i] = map[j][i];
					}
				}
			}
			deepCopyMap();
		}
		
		else if (dir == 3) {  // 아래쪽 이동
			for (int i = 0; i < N; i++) {
				int endOfArray = N - 1;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] != 0) {
						temp[endOfArray--][i] = map[j][i];
					}
				}
			}
			deepCopyMap();
		}
	}
	
	static void merge(int dir) {
		if (dir == 0) {  // 오른쪽 이동
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 1; j--) {
					if (map[i][j] != 0 && map[i][j] == map[i][j - 1]) {
						map[i][j] *= 2;
						map[i][j - 1] = 0;
					}
				}
			}
		}
		
		else if (dir == 1) {  // 왼쪽 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[i][j] != 0 && map[i][j] == map[i][j + 1]) {
						map[i][j] *= 2;
						map[i][j + 1] = 0;
					}
				}
			}
		}
		
		else if (dir == 2) {  // 위쪽 이동
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (map[j][i] != 0 && map[j][i] == map[j + 1][i]) {
						map[j][i] *= 2;
						map[j + 1][i] = 0;
					}
				}
			}
		}
		
		else if (dir == 3) {  // 아래쪽 이동
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 1; j--) {
					if (map[j][i] != 0 && map[j][i] == map[j - 1][i]) {
						map[j][i] *= 2;
						map[j - 1][i] = 0;
					}
				}
			}
		}
	}
	
	static void move(int dir) {
		push(dir);
		merge(dir);
		push(dir);
	}
	
	static int getMaxBlock() {
		int answer = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
		return answer;
	}
	
	static void dfs(int cnt) {
		if (cnt == 5) {
			maxBlock = Math.max(maxBlock, getMaxBlock());
			return;
		}
		
		int[][] backup = new int[N][N];
		for (int i = 0; i < N; i++) backup[i] = map[i].clone();
		
		for (int d = 0; d < 4; d++) {
			move(d);  // 이동
			dfs(cnt + 1);
			
			for (int i = 0; i < N; i++) map[i] = backup[i].clone();  // 원상 복구
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = nextInt();
		map = new int[N][N];
		temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = nextInt();
			}
		}
		
		maxBlock = 0;
		dfs(0);
		System.out.print(maxBlock);
	}
}
