import java.io.*;
import java.util.*;

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
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = nextInt();
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = nextInt();
			count.put(num, count.getOrDefault(num, 0) + 1);
		}
		int M = nextInt();
		for (int i = 0; i < M; i++) {
			int num = nextInt();
			sb.append(count.getOrDefault(num, 0)).append(" ");
		}
		System.out.println(sb);
	}
}
