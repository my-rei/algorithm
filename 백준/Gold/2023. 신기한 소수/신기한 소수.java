import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int N;
	static List<Integer> odds;
	static boolean[] oddsList;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
//		odds = new ArrayList<>();
//		odds.add(2);
//
//		oddsList = new boolean[(int) Math.pow(10, N)];
//		findAllOdd();
//		for (int i = (int) Math.pow(10, N - 1); i < (int) Math.pow(10, N); i++) {
//			if (!oddsList[i]) {
//				System.out.println(i);
//			}
//
//		}
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
			// System.out.println(target*10+i);
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

	static void findAllOdd() {
		// 에라토스테네스의 체
		oddsList[0] = true;
		oddsList[1] = true;

		List<Integer> oddListTemp = new ArrayList<>();
		for (int k = 1; k < N + 1; k++) {
			for (int i = 2; i < Math.pow(10, k); i++) {
				boolean flag = false;
				for (int o : oddListTemp) {
					if (i != o && i % o == 0) {
						flag = true;
					}
				}
				if (!flag) {
					oddListTemp.add(i);
				} else {
					oddsList[i] = true;
				}

			}

			for (int i = 1; i < Math.pow(10, k - 1); i++) {
				if (oddsList[i]) {
					for (int j = 0; j < 10; j++) {
						oddsList[i * 10 + j] = true;
					}
				}
			}

		}

	}
}
