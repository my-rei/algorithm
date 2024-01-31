import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		String[] numsStr = br.readLine().split(" ");
		int[] nums = new int[n];
		int[] sumList = new int[n + 1];

		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(numsStr[i]);
			sumList[i] = totalSum;
			totalSum += nums[i];
		}

		sumList[n] = totalSum;

		// System.out.println(Arrays.toString(sumList));
		for (int k = 0; k < m; k++) {
			String[] ij = br.readLine().split(" ");
			int i = Integer.parseInt(ij[0]);
			int j = Integer.parseInt(ij[1]);
			int sum = 0;

			sb.append(sumList[j] - sumList[i - 1] + "\n");
		}

		System.out.println(sb);
	}
}
