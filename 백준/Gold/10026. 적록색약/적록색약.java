import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[][] delta = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		boolean[][] visitedN = new boolean[N][N];
		boolean[][] visitedY = new boolean[N][N];
		int cntN = 0, cntY = 0;

		Queue<Integer[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visitedN[i][j] == false) {
					queue.add(new Integer[] { i, j });
					cntN++;

					while (!queue.isEmpty()) {
						for (int[] d : delta) {
							int tI = queue.peek()[0] + d[0];
							int tJ = queue.peek()[1] + d[1];

							if (tI > -1 && tI < N && tJ > -1 && tJ < N
									&& map[tI][tJ] == map[queue.peek()[0]][queue.peek()[1]]
									&& visitedN[tI][tJ] == false) {
								queue.add(new Integer[] { tI, tJ });
								visitedN[tI][tJ] = true;
							}
						}
						queue.poll();
					}
				}
			}
		}

		queue.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visitedY[i][j] == false) {
					queue.add(new Integer[] { i, j });
					cntY++;

					while (!queue.isEmpty()) {
						for (int[] d : delta) {
							int tI = queue.peek()[0] + d[0];
							int tJ = queue.peek()[1] + d[1];

							if (tI > -1 && tI < N && tJ > -1 && tJ < N && visitedY[tI][tJ] == false) {
								if (map[tI][tJ] == map[queue.peek()[0]][queue.peek()[1]]
										|| (map[tI][tJ] == 'G' && map[queue.peek()[0]][queue.peek()[1]] == 'R')
										|| (map[tI][tJ] == 'R' && map[queue.peek()[0]][queue.peek()[1]] == 'G')) {
									queue.add(new Integer[] { tI, tJ });
									visitedY[tI][tJ] = true;
								}

							}
						}
						queue.poll();
					}
				}
			}
		}
		
		System.out.println(cntN+" "+cntY);

	}
}
