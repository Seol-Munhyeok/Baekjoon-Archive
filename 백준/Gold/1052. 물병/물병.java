import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int answer = 0;
		for (int i = 0; i <= 10_000_000; i++) {
			if (Integer.bitCount(N + i) <= K) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
