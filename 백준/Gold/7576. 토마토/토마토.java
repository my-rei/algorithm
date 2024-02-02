import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] mn = br.readLine().split(" ");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);

		int[][] tom = new int[n][m];
		int[][] days = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				tom[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] delta = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		Queue<Integer[]> queue = new ArrayDeque<>();
		Queue<Integer[]> toms = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tom[i][j] == 1) {
					queue.add(new Integer[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			int curI = queue.peek()[0];
			int curJ = queue.peek()[1];
			int cnt = days[curI][curJ] + 1;

			for (int[] d : delta) {
				if (curI + d[0] > -1 && curI + d[0] < n && curJ + d[1] > -1 && curJ + d[1] < m
						&& tom[curI + d[0]][curJ + d[1]] == 0) {
					if (days[curI + d[0]][curJ + d[1]] != 0) {
						// visited
						if (days[curI + d[0]][curJ + d[1]] <= cnt) {
							continue;
						}
					}
					queue.add(new Integer[] { curI + d[0], curJ + d[1] });
					days[curI + d[0]][curJ + d[1]] = cnt;
				}
			}

			// System.out.println(curI+" "+curJ);
			queue.poll();
		}

		int minDay = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tom[i][j] != -1) {
					// System.out.print(tom[i][j]+"("+days[i][j]+")");
					minDay = Math.max(minDay, days[i][j]);
					if (tom[i][j] == 0 && days[i][j] == 0) {
						minDay = -1;
						break;
					}

				}
			}
			// System.out.println();
			if (minDay == -1)
				break;
		}

		System.out.println(minDay);
	}
}
