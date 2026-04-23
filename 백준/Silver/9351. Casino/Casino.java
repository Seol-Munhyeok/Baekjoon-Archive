import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	
	static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			String str = next();
			int n = str.length();
			
			sb.append("Case #").append(tc).append(":").append("\n");
			
			for (int len = n; len >= 2; len--) {
				boolean found = false;
				for (int start = n - len; start >= 0; start--) {
					int end = start + len - 1;
					if (isPalindrome(str, start, end)) {
						sb.append(str.substring(start, end + 1)).append("\n");
						found = true;
					}
				}
				if (found) break;
			}
		}
		
		System.out.println(sb);
	}
}
