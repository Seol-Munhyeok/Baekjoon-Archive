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
	
	static int F;
	static HashMap<String, String> parent;
	static HashMap<String, Integer> size;
	
	static String find(String x) {
		if (parent.get(x).equals(x)) return x;
		parent.put(x, find(parent.get(x)));
		return parent.get(x);
	}
	
	static void addSet(String a) {
		if (parent.get(a) == null) {
			parent.put(a, a);
			size.put(a, 1);
		}
	}
	
	static boolean union(String a, String b) {
		a = find(a);
		b = find(b);
		
		if (a.equals(b)) return false;
		
		if (size.get(a) < size.get(b)) { String t; t = a; a = b; b = t; }
		
		parent.put(b, a);
		size.put(a, size.get(a) + size.get(b));
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			F = nextInt();
			parent = new HashMap<>();
			size = new HashMap<>();
			
			for (int i = 0; i < F; i++) {
				String a = next(), b = next();
				addSet(a);
				addSet(b);
				union(a, b);
				sb.append(size.get(find(a))).append("\n");
			}
		}
		System.out.println(sb);
	}
}
