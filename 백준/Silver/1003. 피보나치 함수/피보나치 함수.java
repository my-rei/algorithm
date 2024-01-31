import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] map = new int[41][2];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] result = fibonacci(N);
			sb.append(result[0] + " " + result[1] + "\n");
		}

		System.out.println(sb);

	}

	static int[] fibonacci(int n) {
		int[] t = new int[2];
		if (n == 0) {
			t[0] = 1;
			t[1] = 0;
			return t;
		} else if (n == 1) {
			t[0] = 0;
			t[1] = 1;
			return t;
		}

		if (map[n][0] != 0 && map[n][1] != 0) {
			t[0] = map[n][0];
			t[1] = map[n][1];
			return t;
		}

		int[] res1 = fibonacci(n - 1);
		int[] res2 = fibonacci(n - 2);
		map[n][0] = res1[0] + res2[0];
		map[n][1] = res1[1] + res2[1];
		return new int[] { res1[0] + res2[0], res1[1] + res2[1] };
	}
}