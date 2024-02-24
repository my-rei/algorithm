import java.io.*;
import java.util.*;

public class Main {
	static int P = 9, N, maxScore;
	static boolean[] visited;
	static int[][] scores;
	static int[] player;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		visited = new boolean[P];
		scores = new int[N][P];
		player = new int[P];
		maxScore = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < P; j++) {
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 4번 타자 고르기
		player[3] = 0;
		visited[0] = true;

		makePer(0);

		bw.write(Integer.toString(maxScore));
		bw.flush();
	}

	static void makePer(int cnt) {
		if (cnt == P) {
			maxScore = Math.max(maxScore, getScore());
			return;
		}
		if (cnt == 3)
			makePer(cnt + 1);
		else {
			for (int i = 0; i < P; i++) {
				if (!visited[i] && i != 0) {
					visited[i] = true;
					player[cnt] = i;
					makePer(cnt + 1);
					visited[i] = false;
				}
			}
		}

	}

	static int getScore() {
		int res = 0, curN = 0, curOut = 0;
		int[] pos = new int[8]; // 홈 넘어가는 경우도 포함;
		int i = 0;
		while (curN < N) {
			curOut = 0;
			while (curOut < 3) {
				int curS = scores[curN][player[i]];
				if (curS == 0) {
					curOut++;
				} else {
					pos[0]++;
					for (int j = 3; j > -1; j--) {
						if (pos[j] > 0) {
							pos[j + curS]++;
							pos[j]--;
						}
					}
				}
				i = (i + 1) % P;
			}
			// 점수 계산
			for (int j = 0; j < 8; j++) {
				if(j > 3) res += pos[j];
				pos[j] = 0;
			}
			curN++;
		}

		return res;
	}
}