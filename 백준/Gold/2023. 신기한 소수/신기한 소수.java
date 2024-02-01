import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 9; i++) {
			findOdd(1, i);
		}
		System.out.println(sb);
	}

	static void findOdd(int cnt, int target) {
		// 소수가 아니면 돌아간다
		if (!isOdd(target)) {
			return;
		}

		if (cnt == N && isOdd(target)) {
			sb.append(target + "\n");
			return;
		}

		int[] next = new int[] { 1, 3, 7, 9 };
		for (int n : next) {
			findOdd(cnt + 1, target * 10 + n);
		}
	}

	static boolean isOdd(int target) {// full
		if (target == 1)
			return false;
		if (target == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(target); i++) {
			if (target % i == 0) {
				return false;
			}
		}

		return true;
	}
}
