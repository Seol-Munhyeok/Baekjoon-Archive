import java.io.BufferedReader;
import java.io.InputStreamReader;
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
		int[] x = new int[N];
		int[] y = new int[N];
		
		for (int i = 0; i < N; i++) {
			int x1 = nextInt();
			int y1 = nextInt();
			x[i] = x1;
			y[i] = y1;
		}
		
		long sum = 0;
		for (int i = 0; i < N - 1; i++) {
			sum += ((long)x[i] * y[i + 1]);
			sum -= ((long)y[i] * x[i + 1]);
		}
		
		sum += (long)x[N - 1] * y[0];
        sum -= (long)y[N - 1] * x[0];
		
		sum = Math.abs(sum);

        if (sum % 2 == 0) {
            System.out.println((sum / 2) + ".0");
        } else {
            System.out.println((sum / 2) + ".5");
        }
	}
}
