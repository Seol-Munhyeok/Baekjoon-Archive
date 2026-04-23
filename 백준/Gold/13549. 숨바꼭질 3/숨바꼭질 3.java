import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	static final int INF = 1_000_000_000;
	static final int MAX_N = 100_002;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 예외 처리 (목적지가 시작점보다 왼쪽에 있는 경우, -1만 하는 것이 최적)
		if (K <= N) {
			System.out.println(N - K);
			return;
		}
	
		int[] dist = new int[MAX_N];
		Arrays.fill(dist, INF);  // -1 = 미방문
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offerFirst(N);
		dist[N] = 0;
		
		while (!dq.isEmpty()) {
		    int cur = dq.pollFirst();

		    if (cur == K) {
		    	System.out.println(dist[K]);
		    	return;
		    }
		    
		    int next = cur * 2;
		    if (next < MAX_N && dist[next] > dist[cur]) {
		        dist[next] = dist[cur];
		        dq.offerFirst(next);
		    }

		    next = cur - 1;
		    if (next >= 0 && dist[next] > dist[cur] + 1) {
		        dist[next] = dist[cur] + 1;
		        dq.offerLast(next);
		    }

		    next = cur + 1;
		    if (next < MAX_N && dist[next] > dist[cur] + 1) {
		        dist[next] = dist[cur] + 1;
		        dq.offerLast(next);
		    }
		}
	}
}
