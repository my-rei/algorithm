import java.io.*;
import java.util.*;

public class Solution {
	static int N, C, maxCore, minLength;
	static int[][] map;
	static boolean[][] visited;
	static int[] direction;
	static List<int[]> coreList;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			C = 0;
			coreList = new ArrayList<>();
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						C++;
						coreList.add(new int[] { i, j });
					}
				}
			}
			direction = new int[C];
			Arrays.fill(direction, -1);
			// 초기화
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;

//			System.out.println(getLength(1, 1));
//			for (boolean[] b : visited) {
//				for (boolean b1 : b) {
//					System.out.print(b1 ? "1 " : "0 ");
//				}
//				System.out.println();
//
//			}
			dfs(0, 0, 0);
			sb.append("#" + test + " " + minLength + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void dfs(int cnt, int sCnt, int leng) {
		if (cnt == C) {
			if (sCnt == maxCore) {
				minLength = Math.min(leng, minLength);
			} else if (sCnt > maxCore) {
				maxCore = sCnt;
				minLength = leng;
			}
			return;
		}

//		if (sCnt >= maxCore && leng > minLength)
//			return;

		int[] core = coreList.get(cnt);
		int cr = core[0], cc = core[1];
		if (cr == 0 || cr == N - 1 || cc == 0 || cc == N - 1) {
			direction[cnt] = 4;
			dfs(cnt + 1, sCnt + 1, leng);
		} else {
			for (int d = 0; d < 4; d++) {
				int tmpL = canGo(cr, cc, d);
				if (tmpL != Integer.MAX_VALUE) {
					direction[cnt] = d;
					setVisited(cr, cc, d, true);
					dfs(cnt + 1, sCnt + 1, leng + tmpL);
					setVisited(cr, cc, d, false);
					direction[cnt] = -1;
				}
			}
			dfs(cnt + 1, sCnt, leng);
		}
	}

	static int canGo(int r, int c, int d) {
		int result = Integer.MAX_VALUE;

		int cr = r + dr[d], cc = c + dc[d], count = 1;
		while (cr > -1 && cr < N && cc > -1 && cc < N) {
			if ((map[cr][cc] == 1 || visited[cr][cc])) {
				break;
			}
			if (cr == 0 || cr == N - 1 || cc == 0 || cc == N - 1) {
				result = count;
				break;
			}
			count++;
			cr += dr[d];
			cc += dc[d];
		}

		return result;
	}

	static void setVisited(int r, int c, int d, boolean val) {
		int cr = r + dr[d], cc = c + dc[d];
		while (cr > -1 && cr < N && cc > -1 && cc < N) {
			visited[cr][cc] = val;
			cr += dr[d];
			cc += dc[d];
		}
	}

}