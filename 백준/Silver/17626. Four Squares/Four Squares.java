import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[50001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;
		
		for(int i = 5;i<=N;i++) {
			if(Math.pow((int)Math.sqrt(i), 2) == i) {
				dp[i] = 1;
				continue;
			}
			dp[i] = 5;
			for(int j = (int)Math.sqrt(i);j>0;j--) {
				int t = (int)Math.pow(j,2);
				dp[i] = Math.min(dp[t]+dp[i-t], dp[i]);
			}
		}
		

		bw.write(String.valueOf(dp[N]));
		bw.flush();
	}

}