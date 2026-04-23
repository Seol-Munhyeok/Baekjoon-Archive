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
	
	static int minA, minC, minG, minT;
	static int[] cnt = new int[128];  // 'A'=65, ..., 'Z'=90
	
	static boolean possible() {
		return cnt['A'] >= minA && cnt['C'] >= minC && cnt['G'] >= minG && cnt['T'] >= minT;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int S = nextInt(); int P = nextInt();
		char[] str = next().toCharArray();
		minA = nextInt(); minC = nextInt(); minG = nextInt(); minT = nextInt();
 
		// 첫 window 탐색
		for (int i = 0; i < P; i++) {
			char ch = str[i];
			cnt[ch]++;
		}
		
		int answer = 0;
		if (possible()) answer++;
		
		// slide
		int i = 0, j = P - 1;
		while (true) {
			i++; j++;
			if (j >= S) break;
			
			cnt[str[i - 1]]--;
			cnt[str[j]]++;
			
			if (possible()) answer++;
		}
		System.out.println(answer);
	}
}
