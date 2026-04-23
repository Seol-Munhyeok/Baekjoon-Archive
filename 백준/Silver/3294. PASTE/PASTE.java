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
	
	static class Node {
		int value;
		Node prev, next;
	}
	
	static class LinkedList {
		Node head, tail;  // 더미
		
		void init(int n) {
			head = new Node();  // dummy head
			tail = new Node();  // dummy tail
			
			head.next = tail;
			tail.prev = head;
			
			Node cur = head;
			for (int i = 1; i <= n; i++) {
				Node node = new Node();
				node.value = i;
				
				cur.next = node;
				node.prev = cur;
				
				cur = node;
			}
			
			cur.next = tail;
			tail.prev = cur;
		}
		
		void cut(Node a, Node b) {
			Node left = a.prev;
			Node right = b.next;
			
			left.next = right;
			right.prev = left;
			
			a.prev = null;
			b.next = null;
		}
		
		void paste(Node target, Node a, Node b) {
			Node next = target.next;
			
			target.next = a;
			a.prev = target;
			
			b.next = next;
			next.prev = b;
		}
		
		Node getNode(int index) {
			Node cur = head;
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
			return cur;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = nextInt();
		int K = nextInt();
		
		LinkedList linkedList = new LinkedList();
		linkedList.init(N);
		
		for (int i = 0; i < K; i++) {
			int A = nextInt();
			int B = nextInt();
			int C = nextInt();
			Node aNode = linkedList.getNode(A);
			Node bNode = linkedList.getNode(B);
			
			linkedList.cut(aNode, bNode);
			
			Node cNode = linkedList.getNode(C);
			linkedList.paste(cNode, aNode, bNode);
		}
		
		// 출력
		Node cur = linkedList.head;
		for (int i = 0; i < 10; i++) {
			cur = cur.next;
			sb.append(cur.value).append("\n");
		}
		System.out.println(sb);
	}
}
