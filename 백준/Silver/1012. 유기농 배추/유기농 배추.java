import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String[] mnk = br.readLine().split(" ");
			int m = Integer.parseInt(mnk[0]);
			int n = Integer.parseInt(mnk[1]);
			int k = Integer.parseInt(mnk[2]);

			int[][] farm = new int[m][n];
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				String[] xy = br.readLine().split(" ");
				farm[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = 1;
			}

			Queue<Integer[]> queue = new ArrayDeque<>();
			int cnt = 0;
			int[][] dxy = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (farm[i][j] == 1 && visited[i][j] == false) {
						queue.add(new Integer[] { i, j });
						visited[i][j] = true;
						cnt++;

						while (!queue.isEmpty()) {
							int curI = queue.peek()[0];
							int curJ = queue.peek()[1];

							for (int[] d : dxy) {
								int tI = curI + d[0];
								int tJ = curJ + d[1];

								if (tI > -1 && tI < m && tJ > -1 && tJ < n && visited[tI][tJ] == false
										&& farm[tI][tJ] == 1) {
									queue.add(new Integer[] { tI, tJ });
									visited[tI][tJ] = true;
								}
							}

							queue.poll();
						}
					}

				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);

	}
}
