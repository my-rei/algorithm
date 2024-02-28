import java.io.*;
import java.util.*;

public class Solution {
	static int N, X, count, invalid;
	static int[][] map;
	static int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			// 입력부
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 변수 초기화
			count = 0;
			invalid = 0;

			find();
			sb.append("#" + test + " " + (2 * N - invalid) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void find() {
		// 행 탐색
//		int prev 
		int lastIndex = -1;
		for (int i = 0; i < N; i++) {
			lastIndex = -1;
			for (int j = 0; j < N - 1; j++) {
//				System.out.println(i + "," + j + " " + map[i][j] + "?" + map[i][j + 1]+"  "+lastIndex);
				if (map[i][j] == map[i][j + 1])
					continue;
				if (map[i][j] > map[i][j + 1]) {
					if (map[i][j] - map[i][j + 1] == 1 && check(i, j + 1, 0, lastIndex)) {
						lastIndex = j + X;
						j += X-1;
					} else {
						invalid++;
					//	System.out.println("row[" + i + "] invalid Count: " + invalid);
						break;
					}
				}

				else if (map[i][j] < map[i][j + 1]) {
					if (map[i][j + 1] - map[i][j] == 1 && check(i, j, 1, lastIndex)) {
						// j += X-1;
						lastIndex = j;
					} else {
						invalid++;
//						System.out.println("row[" + i + "] invalid Count: " + invalid);
						break;
					}
				}
//				System.out.println();
			}
		}

		for (int j = 0; j < N; j++) {
			lastIndex = -1;
			for (int i = 0; i < N - 1; i++) {
//				System.out.println(i + "," + j + " " + map[i][j] + "?" + map[i+1][j ]+"  "+lastIndex);
				if (map[i][j] == map[i + 1][j])
					continue;
				if (map[i][j] > map[i + 1][j]) {
					if (map[i][j] - map[i + 1][j] == 1 && check(i + 1, j, 2, lastIndex)) {
						lastIndex = i + X;
						i += X-1;
					} else {
						invalid++;
//						System.out.println("col[" + j + "] invalid Count: " + invalid);
						break;
					}
				}

				else if (map[i][j] < map[i + 1][j]) {
					if (map[i + 1][j] - map[i][j] == 1 && check(i, j, 3, lastIndex)) {
						// i += X-1;
						lastIndex = i;
					} else {
						invalid++;
//						System.out.println("col[" + j + "] invalid Count: " + invalid);
						break;
					}
				}
//				System.out.println();
			}
		}
	}

	static boolean check(int r, int c, int dir, int lastIndex) {
		boolean result = true;
		// 낮아진 지점의 길이를 체크
		int cr = r, cc = c, height = map[r][c];
		for (int x = 1; x < X; x++) {
			cr += dr[dir];
			cc += dc[dir];
			if (cr < 0 || cr >= N || cc < 0 || cc >= N || map[cr][cc] != height) {
				result = false;
				break;
			}
			if (dir == 1 && lastIndex >= cc || dir == 3 && lastIndex >= cr) {
//				System.out.printf("(%d,%d)[%d] > %d\n", cr, cc, dir, lastIndex);
				result = false;
				break;
			}
		}
		return result;
	}
}