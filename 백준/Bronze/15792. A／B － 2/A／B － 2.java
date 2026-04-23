import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int a = sc.nextInt(); int b = sc.nextInt();
		boolean[] visited = new boolean[10];
		
		// 정수 부분
		sb.append(a / b).append(".");
		// 소수 부분
		StringBuilder frac = new StringBuilder();
		int rem = a % b;
		rem *= 10;
		int q = rem / b; int r = rem % b;
		if (r == 0) {
			sb.append(q);
			System.out.println(sb);
			return;
		}
		while (r != 0 && !visited[q]) {
			frac.append(q);
			visited[q] = true;
			r *= 10;
			q = r / b; r = r % b;
		}
		
		for (int i = 0; i < 2000 / frac.length(); i++) 
			sb.append(frac);
		System.out.println(sb);
	}
}
