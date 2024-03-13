import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, result;
	static int[] parent, size;
	static boolean[][] vs;
	static Queue<int[]> queue;
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		makeset();
		search();
		wall();
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				sb.append(result[i][j]%10);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void wall() {
		int[] chk = new int[4];
		Arrays.fill(chk, -1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) continue;
				result[i][j] = 1;
				int cnt = 0; 
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d], nc = j + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (map[nr][nc] == 1) continue;
					int pn = parent[nr*M+nc];
					boolean f = false;
					for(int k=0;k<cnt;k++) 
						if(chk[k]==pn) 
							f = true;
					if(f) continue;
					chk[cnt++] = pn;
					result[i][j] += size[pn] % 10;
				}
//				List<Integer> list = new ArrayList<>();
//				for (int d = 0; d < 4; d++) {
//					int nr = i + dr[d], nc = j + dc[d];
//					if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
//					if (map[nr][nc] == 1) continue;
//					int pn = parent[nr*M+nc];
//					if(list.contains(pn)) continue;
//					result[i][j] += size[pn] % 10;
//					list.add(pn);
//				}
			}
		}
	}

	static void search() {
		vs = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !vs[i][j]) {
					bfs(i, j);
				}
			}
		}
		// 분리집합 부모소 정리 및 개수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					size[find(i, j)]++;
				}
			}
		}
	}

	static void bfs(int i, int j) {
		queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		vs[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d], nc = now[1] + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 1)
					continue;
				if (union(nr, nc, now[0], now[1])) {
					vs[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	static void makeset() {
		parent = new int[N * M];
		size = new int[N * M];
		for (int i = 0; i < N * M; i++) parent[i] = i;
	}

	static int find(int r, int c) {
		int convert = r * M + c;
		if (parent[convert] == convert)
			return convert;
		else
			return parent[convert] = find(parent[convert] / M, parent[convert] % M);
	}

	static boolean union(int ra, int ca, int rb, int cb) {
		int pa = find(ra, ca), pb = find(rb, cb);
		if (pa == pb)
			return false;
		parent[pa] = pb;
		return true;
	}

}