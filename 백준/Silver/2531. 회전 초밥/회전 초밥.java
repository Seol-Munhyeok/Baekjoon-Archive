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
    
    static int N, d, k, c, arr[], cnt[];
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = nextInt(); d = nextInt(); k = nextInt(); c = nextInt();
		arr = new int[2 * N];
		cnt = new int[d + 1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}
		
		// arr에 k - 1 개 덧붙이기
		for (int i = N; i < N + k - 1; i++) {
			arr[i] = arr[i - N];
		}
		
		
		int distinct = 0;
		// k개의 윈도우 이동
		for (int i = 0; i < k; i++) {
			if (cnt[arr[i]] == 0) distinct++;
			cnt[arr[i]]++;
		}
		int answer = distinct;
		if (cnt[c] == 0) answer++;
		
		for (int r = k; r < N + k - 1; r++) {
			cnt[arr[r - k]]--;
			if (cnt[arr[r - k]] == 0) distinct--;
			
			if (cnt[arr[r]] == 0) distinct++;
			cnt[arr[r]]++;
			
			int cur = distinct;
			if (cnt[c] == 0) cur++;
			answer = Math.max(answer, cur);
			
			if (answer == k + 1) break;
		}
		
		System.out.println(answer);
    } 
}
