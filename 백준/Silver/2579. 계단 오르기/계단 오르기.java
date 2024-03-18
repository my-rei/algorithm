import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		for(int i = 1;i<=N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		if(N == 1) { bw.write(String.valueOf(stairs[1])); bw.flush(); return; }
		int[] dp = new int[N+1];
		dp[0] = 0; dp[1] = stairs[1]; dp[2] = stairs[1]+stairs[2];
		for(int i = 3;i<=N;i++) {
			dp[i] = Math.max(dp[i-3]+stairs[i-1], dp[i-2])+stairs[i];
		}
//		System.out.println(Arrays.toString(dp));
		bw.write(String.valueOf(dp[N]));
		bw.flush();
	}
}