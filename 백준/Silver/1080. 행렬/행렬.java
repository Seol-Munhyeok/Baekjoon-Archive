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
    
    static int N, M, A[][], B[][];
    
    static void flipMatrix(int y, int x) {
    	for (int dy = 0; dy < 3; dy++) {
    		for (int dx = 0; dx < 3; dx++) {
    			A[y + dy][x + dx] ^= 1;
    		}
    	}
    }
    
    public static void main(String[] args) throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
        
    	N = nextInt(); M = nextInt();
    	
    	A = new int[N][M];
    	B = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		String line = next();
    		for (int j = 0; j < M; j++) {
    			A[i][j] = line.charAt(j) - '0';
    		}
    	}
    	for (int i = 0; i < N; i++) {
    		String line = next();
    		for (int j = 0; j < M; j++) {
    			B[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	// 행렬의 길이가 3 미만이면 연산 불가 -> 같으면 0, 아니면 -1
    	if (N < 3 || M < 3) {
    		for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			if (A[i][j] != B[i][j]) {
        				System.out.println(-1);
        				return;
        			}
        		}
        	}
    		System.out.println(0);
    		return;
    	}
    	
    	// 배열 순회 중, A와 B가 다른 순간 반드시 뒤집어야 함
    	int answer = 0;
    	for (int i = 0; i <= N - 3; i++) {
    		for (int j = 0; j <= M - 3; j++) {
    			if (A[i][j] != B[i][j]) {
    				flipMatrix(i, j);
    				answer++;
    			}
    		}
    	}
    	
    	// A와 B가 같은 지 확인
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if (A[i][j] != B[i][j]) {
    				System.out.println(-1);
    				return;
    			}
    		}
    	}
    	System.out.println(answer);	
    }
}
