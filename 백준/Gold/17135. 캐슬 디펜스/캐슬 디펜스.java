import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, D;
	static int[][] arr;
	
	static String next() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	static int findTarget(int[][] map, int ar, int ac) {
		int bestDist = 0x3f3f3f3f;
		int bestR = -1, bestC = -1;
		
		for (int r = 0; r < ar; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 1) continue;
				
				int dist = Math.abs(ar - r) + Math.abs(ac - c);
				if (dist > D) continue;
				
				// 우선순위: dist 작은 것, dist 같으면 c 작은 것
				if (dist < bestDist || (dist == bestDist && c < bestC)) {
					bestDist = dist;
					bestR = r;
					bestC = c;
				}
			}
		}
		
		return (bestR == -1) ? -1 : (bestR * M + bestC);
	}
	
	static int simulate(int a, int b, int c) {
		// 1) 원본 맵 복사
		int[][] map = new int[N][M];
		for (int r = 0; r < N; r++) {
			map[r] = arr[r].clone();
		}
		
		int kill = 0;
		int[] archers = {a, b, c};
		
		 // 2) 최대 N턴 진행 (적이 내려오면 결국 N턴 안에 끝남)
		for (int turn = 0; turn < N; turn++) {
			int ar = N - turn;  // 궁수의 가상 row (처음 N, 매턴 1씩 위로)
		
			// 3) 이번 턴에 제거할 타겟(중복 제거)
			Set<Integer> targets = new HashSet<>();
			
			// 4) 궁수 3명 각각 타겟 1명 선정
			for (int ac : archers) {
				int key = findTarget(map, ar, ac);
				if (key != -1) targets.add(key);
			}
			
			// 5) 동시 제거
			for (int key : targets) {
				int r = key / M;
				int col = key % M;
				if (map[r][col] == 1) {
					map[r][col] = 0;
					kill++;
				}
			}
			// 5) 적 이동: ar을 올리는 방식이라 map shift 불필요
		}
		
		return kill;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = nextInt(); M = nextInt(); D = nextInt();
		arr = new int[N][M];
		
		// 입력 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = nextInt();
			}
		}
		
		int answer = -1;
		// 가능한 모든 3곳에 궁수 배치
		for (int i = 0; i < M-2; i++) {
			for (int j = i+1; j < M-1; j++) {
				for (int k = j+1; k < M; k++) {
					answer = Math.max(answer, simulate(i, j, k));
				}
			}
		}
		
		System.out.println(answer);
	}
}
