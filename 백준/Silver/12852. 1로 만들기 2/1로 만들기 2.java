import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N<4?4:N+1];
		dp[1] = 0;
		dp[2] = 1; 
		dp[3] = 1; 
		for(int i = 4;i<=N;i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		sb.append(dp[N]+"\n"+N+" ");
		int cur = N;
		for(int i = N;i>0;i--) {
			if(dp[cur]-1 == dp[i]) {
				if((cur-1 == i)||(cur%2==0&&cur/2 == i)||(cur%3==0&&cur/3==i)) {
					cur = i;
					sb.append(cur+" ");
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		
//		System.out.println(Arrays.toString(dp));
	}
}