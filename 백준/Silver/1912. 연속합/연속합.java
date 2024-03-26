import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		long[] dp = new long[N];
		dp[0] = tmp; long maxSum = tmp;
		for(int i = 1;i<N;i++) {
			tmp = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(tmp+dp[i-1], tmp);
			maxSum = Math.max(dp[i], maxSum);
		}
		bw.write(String.valueOf(maxSum));
		bw.flush();
	}
}