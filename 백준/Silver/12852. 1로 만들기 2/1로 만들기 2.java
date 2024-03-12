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
		List<Integer>[] list = new List[N<4?4:N+1];
		for(int i = 0;i<4;i++) list[i] = new ArrayList<Integer>();
		dp[1] = 0; 
		dp[2] = 1; list[2].add(2);
		dp[3] = 1; list[3].add(3); 
		for(int i = 4;i<=N;i++) {
			int flag = 1;
			dp[i] = dp[i-1]+1;
			if(i%2==0 && dp[i] > dp[i/2]+1) {
				dp[i] = dp[i/2]+1;
				flag = 2;
			}
			if(i%3==0 && dp[i] > dp[i/3]+1) {
				dp[i] = dp[i/3]+1;
				flag = 3;
			}
			list[i] = new ArrayList<>(flag == 1? list[i-1]:list[i/flag]);
			list[i].add(i);
		}
		
		sb.append(dp[N]+"\n");
		for(int i = list[N].size()-1;i>-1;i--) {
			sb.append(list[N].get(i)+" ");
		}
		sb.append(1);
		bw.write(sb.toString());
		bw.flush();
		
//		System.out.println(Arrays.toString(dp));
	}
}