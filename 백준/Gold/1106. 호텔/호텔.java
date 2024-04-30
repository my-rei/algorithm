import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[N+1];
		int[] buyer = new int[N+1];
		int minB = Integer.MAX_VALUE, maxC = 0;
		for(int i = 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			buyer[i] = Integer.parseInt(st.nextToken());
			minB = Math.min(buyer[i], minB);
			maxC = Math.max(cost[i], maxC);
		}
		
		int[][] dp = new int[(C/minB+1)*maxC+1][N+1];
		int c = 0;
		for(;c<=(C/minB+1)*maxC;c++) {
			for(int i = 1;i<=N;i++) {
				if(c-cost[i] >= 0) {
					dp[c][i] = dp[c-cost[i]][N] + buyer[i];  
				}
				dp[c][i] = Math.max(dp[c][i], dp[c][i-1]);
			}
			if(dp[c][N] >= C) break; 
		}

		
		bw.write(String.valueOf(c));
		bw.flush();
	
	}
}