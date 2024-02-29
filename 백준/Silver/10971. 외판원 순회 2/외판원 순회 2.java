import java.io.*;
import java.util.*;

public class Main {
	static int N, minDistance;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minDistance = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			visited[i] = true;
			dfs(1, 0, i, i);
			visited[i] = false;
		}
		bw.write(String.valueOf(minDistance==Integer.MAX_VALUE? "0":minDistance));
		bw.flush();
	}
	
	static void dfs(int count, int dis, int now, int start) {
		if(dis > minDistance) return;
		if(count == N) {
			//System.out.println("====== distance:"+(dis+map[now][start]));
			if(map[now][start] != 0)
				minDistance = Math.min(minDistance, dis+map[now][start]);
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if(!visited[i] && map[now][i] != 0) {
				//System.out.printf("[%d] %d -> %d (%d) : %d\n", start, now, i, map[now][i], (dis+map[now][i]));
				visited[i] = true;
				dfs(count+1, dis+map[now][i], i, start);
				visited[i] = false;
			}
		}
	}
}