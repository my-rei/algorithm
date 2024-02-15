import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		
		int[] dp = new int[50001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		for(int i = 5;i<=n;i++) {
			if(isSqrt(i)) {dp[i] = 1; continue;}
			int t = (int) Math.sqrt(i);
			int minC = 5;
			for(int k = t;k>0;k--) {
				
				if (dp[(int)Math.pow(k, 2)] != 0 || dp[i - (int)Math.pow(k, 2)] != 0) {
					minC = Math.min(dp[(int)Math.pow(k, 2)]+dp[i - (int)Math.pow(k, 2)], minC);
					}
			}
			dp[i] = minC;
		}
		System.out.println(dp[n]);
	}
	static boolean isSqrt(int n) {
		return Math.pow((int)Math.sqrt(n), 2) == n;
	}
}
