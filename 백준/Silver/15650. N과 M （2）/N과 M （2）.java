import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static StringBuilder st;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");

		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		st = new StringBuilder();

		nums = new int[M];
		
		findSeq(0, 1);
		
		System.out.println(st);

	}

	static void findSeq(int cnt, int start) {
		if (cnt == M) {
			st.append(Arrays.toString(nums).replaceAll("[\\[\\]\\,]", "") + "\n");
			return;
		}

		for (int i = start; i < N + 1; i++) {
			nums[cnt] = i;
			findSeq(cnt + 1, i + 1);
		}
	}
}