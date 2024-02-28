import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		dp = new int[30][30];
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			sb.append(combi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static int combi(int r, int n) {
		
		if(dp[n][r] != 0) return dp[n][r];
		else {
			if(r == 0 || n == r) return dp[n][r] = 1;
			if(r == 1) return dp[n][r] = n;
			else return dp[n][r] = combi(r, n-1) + combi(r-1, n-1);
		}
	}
}