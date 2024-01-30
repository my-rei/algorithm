import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] dXy = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int t = 0; t < T; t++) {
			String[] mnk = br.readLine().split(" ");
			int m = Integer.parseInt(mnk[0]);
			int n = Integer.parseInt(mnk[1]);
			int k = Integer.parseInt(mnk[2]);

			int[][] farm = new int[m][n];

			for (int j = 0; j < k; j++) {
				String[] xy = br.readLine().split(" ");
				farm[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = 1;
			}

			int snail = 0;

			Queue<Integer[]> queue = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (farm[i][j] == 1) {
						queue.clear();

						queue.add(new Integer[] { i, j });

						while (!queue.isEmpty()) {
							int x = queue.peek()[0];
							int y = queue.peek()[1];

							for (int[] d : dXy) {
								if (x + d[0] > -1 && x + d[0] < m && y + d[1] > -1 && y + d[1] < n) {
									if (farm[x + d[0]][y + d[1]] == 1) {
										queue.add(new Integer[] { x + d[0], y + d[1] });
										farm[x + d[0]][y + d[1]] = 0;
									}
								}
							}

							queue.poll();
						}

						snail++;
					}
				}
			}

			sb.append(snail + "\n");

		}

		System.out.println(sb);

	}
}
