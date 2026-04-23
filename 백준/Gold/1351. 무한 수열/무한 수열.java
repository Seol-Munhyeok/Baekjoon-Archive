import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static long N, P, Q;
	static Map<Long, Long> mp;
	
	static long go(long x) {
		if (mp.containsKey(x)) return mp.get(x);
		if (x == 0) {
			mp.put(0L, 1L);
			return 1L;
		}
		long val = go(x / P) + go(x / Q);
		mp.put(x, val);
		return val;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		mp = new HashMap<>();
		
		System.out.println(go(N));
	}
}
