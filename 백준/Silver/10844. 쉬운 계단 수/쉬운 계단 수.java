import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), res = 0;
		int[][] dp = new int[N][10];
		for(int i = 1;i<10;i++) dp[0][i] = 1;
		for(int i = 1;i<N;i++) {
			for(int j = 1;j<9;j++) dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
		}
		for(int i = 0;i<10;i++) res = (res+dp[N-1][i])%1000000000;
		bw.write(String.valueOf(res));
		bw.flush();
	}
}