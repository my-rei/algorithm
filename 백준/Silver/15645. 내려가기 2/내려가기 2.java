import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][3];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
			num[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] dp = new int[N+1][3][2];
		for(int i = 1;i<N+1;i++) {
			dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + num[i-1][0];
			dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + num[i-1][0];
			dp[i][1][0] = Math.max(dp[i-1][0][0], Math.max(dp[i-1][1][0], dp[i-1][2][0])) + num[i-1][1];
			dp[i][1][1] = Math.min(dp[i-1][0][1], Math.min(dp[i-1][1][1], dp[i-1][2][1])) + num[i-1][1];
			dp[i][2][0] = Math.max(dp[i-1][1][0], dp[i-1][2][0]) + num[i-1][2];
			dp[i][2][1] = Math.min(dp[i-1][1][1], dp[i-1][2][1]) + num[i-1][2];
		}
		
//		for(int i = 0;i<=N;i++) {
//			System.out.println(dp[i][0][0]+" "+dp[i][1][0]+" "+dp[i][2][0]);
//		}
		
		bw.write(Math.max(dp[N][0][0],  Math.max(dp[N][1][0], dp[N][2][0]))+" "+Math.min(dp[N][0][1],  Math.min(dp[N][1][1], dp[N][2][1])));
		bw.flush();
		
	}
}