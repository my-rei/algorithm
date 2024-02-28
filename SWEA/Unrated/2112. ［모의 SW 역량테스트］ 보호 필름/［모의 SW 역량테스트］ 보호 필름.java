import java.io.*;
import java.util.*;

public class Solution {
	static int D, W, K, minCount;
	static int[] drop;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			drop = new int[D];
			Arrays.fill(drop, -1);
			for(int i = 0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			minCount = Integer.MAX_VALUE;
			dfs(0,0);
			sb.append("#"+test+" "+minCount+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void dfs(int cnt, int change) {
		if(change > minCount) return;
		if(cnt == D) {
			if(check()) {
				minCount = Math.min(minCount, change);
			}
			return;
		}
		drop[cnt] = -1;
		dfs(cnt+1, change);
		drop[cnt] = 0;
		dfs(cnt+1, change+1);
		drop[cnt] = 1;
		dfs(cnt+1, change+1);
	}
	
	static boolean check() {
		for(int j = 0;j<W;j++) {
			int prev = drop[0] == -1? map[0][j]:drop[0], count = 1;
			for(int i = 1;i<D;i++) {
				int cur = drop[i] == -1? map[i][j]:drop[i];
				if(prev == cur) {
					if(++count == K) break;
				} else {
					prev = cur;
					count = 1;
				}
			}
			if(count < K) return false;
		}
		return true;
	}
}