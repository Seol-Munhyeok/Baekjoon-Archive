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
	
	static class Trie {
		static class Node {
			Node[] child = new Node[10];
			boolean isEnd;
		}
		
		Node root = new Node();
		
		boolean insert(String s) {
			Node cur = root;
			
			for (char c : s.toCharArray()) {
				int idx = c - '0';
				
				if (cur.child[idx] == null) {
					cur.child[idx] = new Node();
				}
				cur = cur.child[idx];
				
				// (1) 기존 번호가 더 짧은 prefix인 경우
				if (cur.isEnd) return false;
			}
			
			// (2) 내가 더 짧은 prefix인 경우
			for (int i = 0; i < 10; i++) {
				if (cur.child[i] != null) return false;
			}
			
			cur.isEnd = true;
			return true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Trie trie = new Trie();
			int N = nextInt();
			
			boolean ok = true;
			for (int i = 0; i < N; i++) {
				String str = next();
				
				if (ok && !trie.insert(str)) {
					ok = false;
				}
			}
			
			sb.append(ok ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb);
	}
}
