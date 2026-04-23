import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static String next() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
	
	static int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
	
	static double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			double N = nextDouble();
			int[] arr = new int[(int) N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = nextInt();
				sum += arr[i];
			}
			double avg = (double) sum / N;
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] > avg) count++;
			}
			
			double answer = (double) count * 100 / N;
			sb.append(String.format("%.3f%%\n", answer));
		}
		System.out.println(sb);
	}
}
