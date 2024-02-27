import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, result;
	static int[][] map;
	static int[] dr = { 1,0,-1,0}, dc = { 0,1,0,-1 }, ddr = {0,1,0,-1}, ddc= {1,0,-1,0};
	static boolean[] visited;
	static Spin[] sList;
	
	static class Spin {
		int r, c, s;

		public Spin(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sList = new Spin[K];
		visited=new boolean[K];
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			sList[i] = new Spin(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
		}
		
		result = Integer.MAX_VALUE;
		dfs(0);
//		spin(2,3,2);
//		spinBack(2,3,2);
//		
//		for(int i = 0;i<N;i++) {
//			for(int j =0;j<M;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		bw.write(String.valueOf(result));
		bw.flush();
	}
	
	static void dfs(int cnt) {
		if(cnt == K) {
			result = Math.min(getMin(), result);
		}
		for(int i = 0;i<K;i++) {
			if(!visited[i]) {
				visited[i] = true;
				spin(sList[i].r, sList[i].c, sList[i].s);
				dfs(cnt+1);
				spinBack(sList[i].r, sList[i].c, sList[i].s);
				visited[i] = false;
			}
		}
	}
	
	static int getMin() {
		int minSum = Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			int sum = 0;
			for(int j = 0;j<M;j++) {
				sum+=map[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		return minSum;
	}

	static void spin(int r, int c, int s) {
		int sr, sc, nr, nc;
		for (int size = 1; size <= s; size++) {
			sr = r - size; sc = c - size;
			nr = sr; nc = sc;
			int tmp = map[sr][sc];
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < size * 2 ; i++) {
					nr = sr + dr[d]; nc = sc + dc[d];
//					System.out.println(d+" | "+i+" "+sr+","+sc+"->"+nr+","+nc);
					map[sr][sc] = map[nr][nc];
					sr = nr;
					sc = nc;
				}
			}
			map[nr][nc+1] = tmp;
		}
	}
	
	static void spinBack(int r, int c, int s) {
		int sr, sc, nr, nc;
		for (int size = 1; size <= s; size++) {
			sr = r - size; sc = c - size;
			nr = sr; nc = sc;
			int tmp = map[sr][sc];
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < size * 2 ; i++) {
					nr = sr + ddr[d]; nc = sc + ddc[d];
//					System.out.println(d+" | "+i+" "+sr+","+sc+"->"+nr+","+nc);
					map[sr][sc] = map[nr][nc];
					sr = nr;
					sc = nc;
				}
			}
			map[nr+1][nc] = tmp;
		}
	}
}