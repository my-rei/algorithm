import java.io.*;
import java.util.*;

public class Solution {
	static int N, minG;
	static Queue<int[]> q;
	static int[][] map, vs;
	static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		q = new ArrayDeque<>();
		for(int test = 1;test<=T;test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			vs = new int[N][N];
			minG = Integer.MAX_VALUE;
			for(int i = 0;i<N;i++) {
				String str = br.readLine();
				Arrays.fill(vs[i], Integer.MAX_VALUE);
				for(int j = 0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
				}
			}
			
			
			q.add(new int[] {0,0,0});
			while(!q.isEmpty()) {
				int[] now = q.poll();
//				System.out.println(Arrays.toString(now));
				for(int d=0;d<4;d++) {
					int nr = now[0]+dr[d], nc = now[1]+dc[d];
					if(nr<0||nr>=N||nc<0||nc>=N) continue;
					int n =  now[2]+map[nr][nc];
					if(nr==N-1&&nc==N-1) {
						minG = Math.min(minG, n);
					}
					if(vs[nr][nc] <= n) continue;
					vs[nr][nc] = n;
					q.add(new int[] {nr, nc, n});
				}
			}
			
			
			bw.append("#").append(String.valueOf(test)).append(" ").append(String.valueOf(minG)).append("\n");
		}
		bw.flush();
	}
}