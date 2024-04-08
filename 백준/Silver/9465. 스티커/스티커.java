import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] sc = new int[N][2];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0;i<N;i++) {
				sc[i][0] = Integer.parseInt(st1.nextToken());
				sc[i][1] = Integer.parseInt(st2.nextToken());
			}
			if(N==1) {
				sb.append(Math.max(sc[0][0], sc[0][1])).append("\n");
				continue;
			}
			int[][] dp = new int[N][2];
			dp[0] = sc[0];
			dp[1][0] = dp[0][1]+sc[1][0];
			dp[1][1] = dp[0][0]+sc[1][1];
			for(int i = 2;i<N;i++) {
				dp[i][0] = Math.max(dp[i-1][1]+sc[i][0], Math.max(dp[i-2][0], dp[i-2][1])+sc[i][0]);
				dp[i][1] = Math.max(dp[i-1][0]+sc[i][1], Math.max(dp[i-2][0], dp[i-2][1])+sc[i][1]);
			}
			
//			for(int i = 0;i<N;i++) {
//				System.out.print(dp[i][0]+" ");
//			}
//			System.out.println();
//			for(int i = 0;i<N;i++) {
//				System.out.print(dp[i][1]+" ");
//			}
//			System.out.println();
			sb.append(Math.max(dp[N-1][0], dp[N-1][1])).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}