import java.util.*;
import java.io.*;

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
		
		int N = nextInt(); int K = nextInt();
		List<int[]> jewels = new ArrayList<>();
		List<Integer> bags = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int M = nextInt(); int V = nextInt();
			jewels.add(new int[] {M, V});
		}
		for (int i = 0; i < K; i++) {
			int C = nextInt();
			bags.add(C);
		}
		
		jewels.sort((a, b) -> Integer.compare(a[0], b[0]));
		Collections.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		long answer = 0;
		int j = 0;
		for (int i = 0; i < K; i++) {
			while (j < N && jewels.get(j)[0] <= bags.get(i)) {
				pq.offer(jewels.get(j)[1]);
				j++;
			}
			if (!pq.isEmpty()) answer += pq.poll();
		}
		
		System.out.println(answer);
	}
}
