import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder answerSb;
	
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
			Node[] child = new Node[26];
			int passCount;   // 이 노드를 지나간 문자열 수
            int endCount;    // 이 문자열이 정확히 끝난 횟수
		}
		
		Node root = new Node();
		
		void insert(String s) {
			Node cur = root;
			StringBuilder sb = new StringBuilder();
			boolean printed = false;
			
			for (char c : s.toCharArray()) {
				int idx = c - 'a';
				sb.append(c);
				
				if (cur.child[idx] == null) {
					cur.child[idx] = new Node();
					
					if (!printed) {
						answerSb.append(sb).append("\n");
						printed = true;
					}
				}
				
				cur = cur.child[idx];
				cur.passCount++;
			}
			
			if (!printed) {
				if (cur.endCount == 0) {
					answerSb.append(s).append("\n");
				} else {
					answerSb.append(s).append(cur.endCount + 1).append('\n');
				}
			}
			cur.endCount++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		answerSb = new StringBuilder();
		
		int N = nextInt();
		Trie trie = new Trie();
		
		for (int i = 0; i < N; i++) {
			String str = next();
			trie.insert(str);
		}
		System.out.println(answerSb);
	}
}
