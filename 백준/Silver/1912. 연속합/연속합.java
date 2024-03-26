import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		nums[0] = Integer.parseInt(st.nextToken());
		long[] dp = new long[N];
		dp[0] = nums[0]; long maxSum = nums[0];
		for(int i = 1;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(nums[i]+dp[i-1], nums[i]);
			maxSum = Math.max(dp[i], maxSum);
		}
		bw.write(String.valueOf(maxSum));
		bw.flush();
	}
}