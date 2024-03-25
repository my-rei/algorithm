import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] like;
	static int[][] map;
	static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		like = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				like[n][j] = Integer.parseInt(st.nextToken());
			}
			find(n);
		}

		bw.write(String.valueOf(cal()));
		bw.flush();
	}

	static int cal() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int e = 0, f = 0, n = map[i][j];
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d], nc = j + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (map[nr][nc] == 0) e++;
					else {
						for (int l : like[n])
							if (l == map[nr][nc])
								f++;
					}
				}
				result += Math.pow(10, f)/10;
			}
		}
		return result;
	}

	static void find(int n) {
		// 적합한 자리에 배정
		int maxEmpty = -1, maxFriend = -1, er = 0, ec = 0, fr = 0, fc = 0, mec = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					continue;
				int e = 0, f = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d], nc = j + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if (map[nr][nc] == 0) e++;
					else {
						for (int l : like[n])
							if (l == map[nr][nc])
								f++;
					}
				}

				if (f > maxFriend) {
					maxFriend = f;
					maxEmpty = e;
					er = i;
					ec = j;
				} else if (f == maxFriend) {
					if (e > maxEmpty) {
						maxEmpty = e;
						er = i;
						ec = j;
					}
				}
			}
		}

		map[er][ec] = n;
	}
}