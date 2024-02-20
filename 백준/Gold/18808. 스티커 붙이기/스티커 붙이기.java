import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] cover;
	static int N, M, K, lastRow, lastCol;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cover = new boolean[N][M];

		int total = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

			boolean[][] sticker = new boolean[R][C];
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					if (st.nextToken().charAt(0) == '1')
						sticker[r][c] = true;
				}
			}

			total += stick(R, C, sticker);
		}

		System.out.println(total);

	}

	static int stick(int r, int c, boolean[][] sticker) {
		int cnt = 0;

		// 위치 선택
		// 검사 안되면 회전
		// 위치 이동
		boolean flag = false;
		int newR = r, newC = c, sr=0, sc=0;
		for (int i = 0; i < 4 && !flag; i++) {
            for (int cr = 0; cr <= N - newR && !flag; cr++) {
				for (int cc = 0; cc <= M - newC; cc++) {
					if (canStick(cr, cc, newR, newC, sticker)) {
						sr = cr;
						sc = cc;
						flag = true;
						break;
					}
				}
			}
			if (flag)
				break;
			sticker = rotate(newR, newC, sticker);
			int tmp = newR;
			newR = newC;
			newC = tmp;
		}

		if (flag) {
			for (int i = 0; i < newR; i++) {
				for (int j = 0; j < newC; j++) {
					if (sticker[i][j])
						cover[sr + i][sc + j] = true;
				}
			}
			return count(newR, newC, sticker);
		} else 
			return 0;
		
	}

	static int count(int r, int c, boolean[][] sticker) {
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j])
					cnt++;
			}
		}
		return cnt;
	}

	static boolean canStick(int sr, int sc, int r, int c, boolean[][] sticker) {
		if (sr < 0 || sc < 0 || sr + r > N || sc + c > M)
			return false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] && cover[sr + i][sc + j])
					return false;
			}
		}
		return true;
	}

	static boolean[][] rotate(int r, int c, boolean[][] sticker) {
		boolean[][] newSticker = new boolean[c][r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				newSticker[j][r - i - 1] = sticker[i][j];
			}
		}
		return newSticker;
	}
}