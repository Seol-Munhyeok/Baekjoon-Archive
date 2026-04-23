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
	
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = nextInt();
		K = nextInt();
		belt = new int[2 * N];
		robot = new boolean[2 * N];
		
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = nextInt();
		}
		
		int answer = 0;
		int zeroCount = 0;
		while (zeroCount < K) {
			answer++;
			
			// 벨트 및 로봇 회전
			int tempBelt = belt[2 * N - 1];
			boolean tempRobot = robot[2 * N - 1];
			
			for (int i = 2 * N - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
				robot[i] = robot[i - 1];
			}
			belt[0] = tempBelt;
			robot[0] = tempRobot;
			
			// 회전 후 내리는 위치 로봇 즉시 내리기
			robot[N - 1] = false;
			
			// 로봇 이동 (가장 먼저 올라는 로봇부터 -> 역순으로 이동)
			for (int i = N - 1; i >= 0; i--) {
				if (robot[i] && !robot[i + 1] && belt[i + 1] >= 1) {
					robot[i] = false;
					robot[i + 1] = true;
					if (--belt[i + 1] == 0) zeroCount++;
				}
			}
			
			// 이동 후 내리는 위치 로봇 즉시 내리기
			robot[N - 1] = false;
			
			// 올리는 위치에 로봇 올리기
			if (belt[0] >= 1) {
				robot[0] = true;
				if (--belt[0] == 0) zeroCount++;
			}
		}
		
		System.out.println(answer);
	}
}
