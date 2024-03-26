import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N][2];
		dp[0][0] = 0;
		dp[0][1] = 1;
		
		for(int i = 1;i<N;i++) {
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		bw.write(String.valueOf(dp[N-1][0]+dp[N-1][1]));
		bw.flush();
	}
}