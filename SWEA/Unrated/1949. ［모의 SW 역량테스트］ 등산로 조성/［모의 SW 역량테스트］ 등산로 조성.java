import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, maxHeight, maxDis;
	static int[][] map;
	static Queue<int[]> queue;
	static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			queue = new ArrayDeque<>();
			maxHeight = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > maxHeight) {
						queue.clear();
						maxHeight = map[i][j];
						queue.add(new int[] { i, j });
					} else if (map[i][j] == maxHeight)
						queue.add(new int[] { i, j });
				}
			}

			maxDis = 0;
			while (!queue.isEmpty()) {
				int r = queue.peek()[0], c = queue.peek()[1], tmp = map[r][c];
				map[r][c] = 100;
				dfs(r,c,tmp, 1, false);
				map[r][c] = tmp;
				queue.poll();
			}

			sb.append("#"+test+" "+maxDis+"\n");

		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void dfs(int r, int c, int lastVal, int cnt, boolean cut) {
//		System.out.println(r+" "+c+" "+lastVal+" "+cnt+" "+cut);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d], nc = c + dc[d];
			if (nr > -1 && nr < N && nc > -1 && nc < N) {
				int tmp = map[nr][nc];
				if (map[nr][nc] < lastVal) {
					map[nr][nc] = 100;
					dfs(nr, nc, tmp, cnt + 1, cut);
					map[nr][nc] = tmp;
				} else if (!cut && map[nr][nc]- K  < lastVal) {
					for (int k = K; k > 0; k--) {
						if (map[nr][nc] - k < lastVal) {
							map[nr][nc] = 100;
							dfs(nr, nc, tmp-k, cnt+1, true);
							map[nr][nc] = tmp;
						}
					}
				}
			}
		}

		// 갈 곳이 없으면 갱신
		maxDis = Math.max(maxDis, cnt);
	}
}