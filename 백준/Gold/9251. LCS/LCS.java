import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[1001][1001];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				 if (a.charAt(i - 1) == b.charAt(j - 1)) {
					 dp[i][j] = dp[i - 1][j - 1] + 1;
				 }
				 dp[i][j] = Math.max(Math.max(dp[i][j], dp[i - 1][j]), dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
