import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] as, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		as = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			as[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		int m = 0;
		for(int i = 0;i<N;i++) {
			dp[i] = as[i];
			for(int j = 0;j<i;j++) {
				if(as[j]<as[i] && dp[j]+as[i] > dp[i]) {
					dp[i] = dp[j]+as[i];	
				}
			}
			m = Math.max(m, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		bw.write(String.valueOf(m));
		bw.flush();
		
	}
}