import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] orders = new int[N][2];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			orders[i][0] = Integer.parseInt(st.nextToken());
			orders[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] dp = new int[N+1][M+1][K+1];
		for(int i = 1;i<=N;i++) {
			int ham = orders[i-1][0];
			int fri = orders[i-1][1];
			for(int h = 1;h<=M;h++) {
				for(int f=1;f<=K;f++) {
					dp[i][h][f] = dp[i-1][h][f];
					if(ham <= h && fri <= f) {
						dp[i][h][f] = Math.max(dp[i][h][f], dp[i-1][h-ham][f-fri]+1);
					}
				}
			}
		}
		int m = dp[N][0][0];
		for(int h=0;h<=M;h++) {
			for(int f = 0;f<=K;f++) {
				m = Math.max(m, dp[N][h][f]);
			}
		}
		bw.write(String.valueOf(m));
		bw.flush();
		
	}
}