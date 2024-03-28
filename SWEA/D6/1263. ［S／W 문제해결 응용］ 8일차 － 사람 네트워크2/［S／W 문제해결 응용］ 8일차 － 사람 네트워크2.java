import java.io.*;
import java.util.*;

public class Solution {
	static int N, MAX_V = 10000;
	static int[][] dis;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dis = new int[N][N];
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					dis[i][j] = Integer.parseInt(st.nextToken());
					if(dis[i][j] == 0 && i != j) dis[i][j] = MAX_V;
				}
			}
			
			
			for(int k = 0;k<N;k++) {
				for(int i = 0;i<N;i++) {
					for(int j = 0;j<N;j++) {
						if(k == i || k == j || i==j) continue;
						dis[i][j] = Math.min(dis[i][j], dis[i][k]+dis[k][j]);
					}
				}
			}

			int minV = Integer.MAX_VALUE;
			for(int i = 0;i<N;i++) {
				int tmp = 0;
				for(int j = 0;j<N;j++) {
					tmp += dis[i][j];
				}
				minV = Math.min(tmp, minV);
			}
			
			sb.append("#"+test+" "+minV+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}