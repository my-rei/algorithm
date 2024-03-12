import java.io.*;
import java.util.*;

public class Main {
	static int N, M, count;
	static char[][] map;
	static boolean[][] vs;
	static int[][] parent;
	
	static int[] dr = {-1,1,0,0}, dc= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		vs = new boolean[N][M];
		
		for(int i = 0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		makeset();
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(!vs[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		Set<Integer> ps = new HashSet<>();
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				ps.add(find(i,j));
			}
		}
		bw.write(String.valueOf(ps.size()));
		bw.flush();
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {i,j});
		vs[i][j] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			char dir = map[now[0]][now[1]];
			int d = dir=='U'?0:dir=='D'?1:dir=='L'?2:3;
			int nr=now[0]+dr[d], nc=now[1]+dc[d];
			if(nr<0||nr>=N||nc<0||nc>=M) continue;
			if(vs[nr][nc]) {
				union(nr, nc, now[0], now[1]);
			} else {
				vs[nr][nc] = true;
				union(now[0], now[1], nr, nc);
				queue.add(new int[] {nr,nc});
			}
		}
//		print();
	}
	static void print() {
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				System.out.print(parent[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void makeset() {
		parent = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				parent[i][j] = M*i+j;
			}
		}
	}
	
	static int find(int i, int j) {
		if(parent[i][j] == M*i+j) return M*i+j;
		else return parent[i][j] = find(parent[i][j]/M, parent[i][j]%M);
	}
	
	static boolean union(int i, int j, int r, int c) {
		int pa = parent[i][j], pb = parent[r][c];
		if(pa == pb) return false;
		parent[pb/M][pb%M] = pa;
		return true;
	}
}