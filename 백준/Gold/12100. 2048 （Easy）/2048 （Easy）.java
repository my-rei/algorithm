import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] dirR = { 0, 1, 0, -1 }, dirC = { 1, 0, -1, 0 };
	static int maxBlock, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxBlock = findMax(map);
		play(0, findMax(map), map);
		System.out.println(maxBlock);
	}

	static void play(int round, int curMax, int[][] newMap) {
		if (round == 5) {
			maxBlock = Math.max(maxBlock, curMax);
			return;
		}

		// 지금 최대블록을 5-round번 *2해도 maxBlock보다 작을 경우
		if (curMax * Math.pow(2, 5 - round) < maxBlock)
			return;

		for (int i = 0; i < 4; i++) {
			// 움직일 수 없는 경우 continue
			// 이동
			if (canMove(newMap, i)) {
				int[][] res = move(newMap, i);
				play(round + 1, findMax(res), res);
			}
		}
		maxBlock = Math.max(maxBlock, curMax);
	}

	static int findMax(int[][] target) {
		int r = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				r = Math.max(r, target[i][j]);
		return r;
	}

	static int[][] move(int[][] target, int dir) {
		int[][] result = new int[N][N];
		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = target[i][j];
			}
		}

		int dr = dirR[dir], dc = dirC[dir];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cr = dir % 2 == 0 ? i : dir == 1 ? N - j - 1 : j;
				int cc = dir % 2 == 1 ? i : dir == 0 ? N - j - 1 : j;
				int nr = cr + dr, nc = cc + dc;
				while (nr > -1 && nr < N && nc > -1 && nc < N) {
					if (result[nr][nc] != 0) {
						if (result[nr][nc] == result[cr][cc] && !check[nr][nc]) {
							check[nr][nc] = true;
							result[nr][nc] = result[nr][nc] * 2;
							result[cr][cc] = 0;
						}
						break;
					} else {
						result[nr][nc] = result[cr][cc];
						result[cr][cc] = 0;
					}
					cr = nr; cc = nc;
					nr = cr + dr;
					nc = cc + dc;
				}
			}
		}
		return result;
	}

	static boolean canMove(int[][] map, int dir) {
		int dr = dirR[dir], dc = dirC[dir];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cr = dir % 2 == 0 ? i : dir == 1 ? N - j - 1 : j;
				int cc = dir % 2 == 1 ? i : dir == 0 ? N - j - 1 : j;
				int nr = cr + dr, nc = cc + dc;
				if (nr > -1 && nr < N && nc > -1 && nc < N) {
					if (map[nr][nc] != 0) {
						if (map[nr][nc] == map[i][j]) {
							return true;
						}
					} else {
						return true;
					}
				}
			}
		}
		return false;
	}
}