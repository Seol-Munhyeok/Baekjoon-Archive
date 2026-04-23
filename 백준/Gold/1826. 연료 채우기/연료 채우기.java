import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
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
		
		int N = nextInt();
		List<int[]> station = new ArrayList<>(); // {거리, 연료량}
		
		for (int i = 0; i < N; i++) {
			int a = nextInt();
			int b = nextInt();
			station.add(new int[] {a, b});
		}
		
		int L = nextInt();  // 마을까지의 거리
		int P = nextInt();  // 원래 있던 연료의 양 (=지금 당장 갈 수 있는 최대 거리)
		
		// 거리 기준 오름차순
		station.sort((a, b) -> Integer.compare(a[0], b[0]));
		
		// 연료 기준 내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int idx = 0;  // 아직 처리하지 않은 다음 주유소 인덱스
		int count = 0;  // 주유한 횟수
		int reach = P;  // 현재 도달 가능한 최대 거리
		
		while (reach < L) {
			
			// 현재 reach 이하인 주유소를 후보에 넣는다
			while (idx < N && station.get(idx)[0] <= reach) {
				pq.offer(station.get(idx)[1]);
				idx++;
			}
			
			// 모든 주유소에서 주유해도 불가능
			if (pq.isEmpty()) {
				System.out.println(-1);
				return;
			}
			
			// pq에서 가장 많은 연료를 주는 주유소에서 연료 보충
			reach += pq.poll();
			count++;
		}
		
		System.out.println(count);
	}
}
