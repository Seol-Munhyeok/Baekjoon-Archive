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
		int K = nextInt();
		
		List<Integer> list = new ArrayList<>();
		List<Integer> answerList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int startIdx = 0;
		for (int i = 0; i < N; i++) {
			startIdx = (startIdx + K - 1) % list.size();
			int removed = list.remove(startIdx);
			answerList.add(removed);
		}
		
		sb.append("<");
		for (int i = 0; i < N; i++) {
			sb.append(answerList.get(i));
			if (i != N - 1) sb.append(", ");
		}
		sb.append(">");
		System.out.print(sb);
  }
}