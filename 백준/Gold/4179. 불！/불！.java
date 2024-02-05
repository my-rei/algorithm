import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");

		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);

		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean[][] visited = new boolean[r][c];

		Queue<Integer[]> queue = new ArrayDeque<>();
		Queue<Integer[]> fireQueue = new ArrayDeque<>();

		int[][] fireMap = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'F') {
					fireMap[i][j] = 0;
					fireQueue.add(new Integer[] { i, j, 0 });
				} else {
					fireMap[i][j] = -1;
				}

			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'J') {
					map[i][j] = '.';
					visited[i][j] = true;
					queue.add(new Integer[] { i, j, 0 });
					if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
						System.out.println(1);
						return;
					}
				}

			}
		}

		int[][] delta = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int outTime = -1;

		// 불 맵

		while (!fireQueue.isEmpty()) {
			for (int[] d : delta) {
				int curFireI = fireQueue.peek()[0] + d[0];
				int curFireJ = fireQueue.peek()[1] + d[1];
				int curFireT = fireQueue.peek()[2] + 1;
				if (curFireI > -1 && curFireI < r && curFireJ > -1 && curFireJ < c
						&& fireMap[curFireI][curFireJ] == -1 && map[curFireI][curFireJ] != '#') {
					fireMap[curFireI][curFireJ] = curFireT;
					fireQueue.add(new Integer[] { curFireI, curFireJ, curFireT });

				}
			}
			fireQueue.poll();
		}
		
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				System.out.print(fireMap[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("==============");

		while (!queue.isEmpty()) {
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("====");

			for (int[] d : delta) {
				int curI = queue.peek()[0] + d[0];
				int curJ = queue.peek()[1] + d[1];
				int curT = queue.peek()[2] + 1;
				if (curI > -1 && curI < r && curJ > -1 && curJ < c && map[curI][curJ] != 'F'
						&& map[curI][curJ] != '#'&& visited[curI][curJ] == false)  {
//					System.out.println("curI: "+curI+" curJ: "+curJ+" curT: "+curT);
					if (fireMap[curI][curJ] == -1 || fireMap[curI][curJ] > curT) {
			//			System.out.println(curI + " " + curJ);
						visited[curI][curJ] = true;
						queue.add(new Integer[] { curI, curJ, curT });
						if (curI == 0 || curI == r - 1 || curJ == 0 || curJ == c - 1) {
							outTime = curT + 1;
							break;
						}
					}
				}
			}
			if (outTime != -1)
				break;
			queue.poll();
		}

		System.out.println(outTime == -1 ? "IMPOSSIBLE" : outTime);
	}
}
