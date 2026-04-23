import java.util.Scanner;

public class Main {
	
	static int minA, minC, minG, minT;
	static int[] cnt = new int[128];  // 'A'=65, ..., 'Z'=90
	
	static boolean possible() {
		return cnt['A'] >= minA && cnt['C'] >= minC && cnt['G'] >= minG && cnt['T'] >= minT;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt(); int P = sc.nextInt();
		char[] str = sc.next().toCharArray();
		minA = sc.nextInt(); minC = sc.nextInt(); minG = sc.nextInt(); minT = sc.nextInt();
 
		// 첫 window 탐색
		for (int i = 0; i < P; i++) {
			char ch = str[i];
			cnt[ch]++;
		}
		
		int answer = 0;
		if (possible()) answer++;
		
		// slide
		int i = 0, j = P - 1;
		while (true) {
			i++; j++;
			if (j >= S) break;
			
			cnt[str[i - 1]]--;
			cnt[str[j]]++;
			
			if (possible()) answer++;
		}
		System.out.println(answer);
	}
}
