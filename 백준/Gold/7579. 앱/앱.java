import java.io.*;
import java.util.*;

public class Main {
	static int N, M, C;
	static int[] memory, cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); C = 0;
		memory = new int[N]; cost = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			C+=cost[i];
		}

		bw.write(String.valueOf(dpwithcost()));
		bw.flush();
		
		
	}
	
	static int dpwithcost() {
		int[][] dp = new int[N][C+1];
		for(int c = 0;c<=C;c++) {
			if(cost[0] <= c) {
				dp[0][c] = memory[0];
			} else {
				dp[0][c] = -1;
			}
		}
		for(int i = 1;i<N;i++) {
			for(int c= 0;c<=C;c++) {
				if(cost[i] <= c) {
					dp[i][c] = Math.max(memory[i], dp[i-1][c-cost[i]]+memory[i]);
					dp[i][c] = Math.max(dp[i][c], dp[i-1][c]);
				} else {
					dp[i][c] = dp[i-1][c];
				}
			}
		}
		
//		for(int t = 0;t<N;t++) {
//			for(int j = 0;j<=C;j++) {
//				if(t == N-1)
//				System.out.print(dp[t][j] +" ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0;i<=C;i++) {
			if(dp[N-1][i] >= M) {
				return i;
			}
		}
		return C;
	}
	
}