import java.io.*;
import java.util.*;

public class Solution {
	static int N,M;
	static boolean[][] table;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1;test<=T;test++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			table = new boolean[N+1][N+1];
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()), b= Integer.parseInt(st.nextToken());
				table[a][b] = true;
			}
			
			
			//플로이드워샬(2)
			for(int k = 1;k<=N;k++) {
				for(int i = 1;i<=N;i++) {
					for(int j = 1;j<=N;j++) {
						if(i==j||table[i][j]) continue;
						table[i][j] = (table[i][k] && table[k][j]);

					}
				}
			}
			
			int cnt = 0;
			for(int i = 1;i<=N;i++) 
				cnt += count(i);
			
//			sb.append("#"+test+" "+cnt+"\n");
//			sb.append("#").append(test).append(" ").append(cnt).append("\n");
			bw.append("#").append(String.valueOf(test)).append(" ").append(String.valueOf(cnt)).append("\n");
		}
//		bw.write(sb.toString());
		bw.flush();
	}
	
	static int count(int t) {
		for(int i = 1;i<=N;i++) {
			if(i != t && !table[i][t] && !table[t][i]) {
				return 0;
			}
//			r++;
//			if(table[i][t]) r++;
//			if(table[t][i]) r++;
		}
		return 1;
	}
}