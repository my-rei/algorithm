import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[k+1][n];
		int[] ns = new int[n];
		
		for(int i = 0;i<n;i++)
			ns[i] = Integer.parseInt(br.readLine());
		Arrays.sort(ns);
		for(int i = 1;i<=k;i++) {
			for(int j = 0;j<n;j++) {
				if(i-ns[j] < 0) break;
				for(int l=0;l<=j;l++) {
					dp[i][j] += dp[i-ns[j]][l];
				}
				if(i-ns[j] == 0) { dp[i][j] = 1; }
			}
		}
		
		int sum = 0;
		for(int j=0;j<n;j++)
			sum += dp[k][j];
		
		System.out.println(sum);
		
	}
}