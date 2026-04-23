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
			Map<String, Node> child = new TreeMap<>();  // Key 값이 정렬된 상태로 저장됨
			boolean isEnd;
		}
		
		Node root = new Node();
		
		void insert(String[] strings) {
			Node cur = root;
			for (String str : strings) {
				cur.child.putIfAbsent(str, new Node());
				cur = cur.child.get(str);
			}
			cur.isEnd = true;
		}
		
		void dfs(Node cur, int depth) {
			for (String key : cur.child.keySet()) {
				for (int i = 0; i < depth; i++) sb.append("--");
				sb.append(key).append("\n");
				
				dfs(cur.child.get(key), depth + 1);
			}
		}
		
		// dfs 탐색 = 사전순 출력
		void print() {
			dfs(root, 0);
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = nextInt();
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			int M = nextInt();
			String[] strings = new String[M];
			for (int j = 0; j < M; j++) {
				String str = next();
				strings[j] = str;
			}
			trie.insert(strings);
		}
		
		trie.print();
		
		System.out.println(sb);
	}
}
