import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
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
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<String> set = new HashSet<>();
		

		int N = nextInt();
		for (int i = 0; i < N; i++) {
			String s = next();
			set.add(s);
		}
		
		int count = 0;
		int M = nextInt();
		for (int i = 0; i < M; i++) {
			String st = next();
			if (set.contains(st)) count++;
		}
		
		System.out.println(count);
	}
}
