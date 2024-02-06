import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] farm;
	static int M, N, K;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] mnk = br.readLine().split(" ");
			M = Integer.parseInt(mnk[0]);
			N = Integer.parseInt(mnk[1]);
			K = Integer.parseInt(mnk[2]);
			farm = new boolean[M][N];
			for (int i = 0; i < K; i++) {
				String[] xy = br.readLine().split(" ");
				farm[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = true;
			}

			int worm = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (farm[i][j]) {
						worm++;
						farm[i][j] = false;
						dfs(i, j);
					}

				}
			}
			sb.append(worm + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int curI, int curJ) {
		for (int[] d : delta) {
			int nextI = curI + d[0];
			int nextJ = curJ + d[1];
			if (nextI > -1 && nextI < M && nextJ > -1 && nextJ < N && farm[nextI][nextJ]) {
				farm[nextI][nextJ] = false;
				dfs(nextI, nextJ);
			}
		}
	}
}
