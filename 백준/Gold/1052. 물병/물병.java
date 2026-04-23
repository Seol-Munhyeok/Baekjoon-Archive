import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int answer = 0;
		while (Integer.bitCount(N) > K) {
		    int lowbit = N & -N;
		    answer += lowbit;
		    N += lowbit;
		}
		System.out.println(answer);
	}
}
