import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		// 현재 자리에서 바로 탈출하는 경우(1초)
		// visited 조건 확인 
		// 아예 불이 붙지 않는 자리일 경우
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] wh = br.readLine().split(" ");
			int w = Integer.parseInt(wh[0]);
			int h = Integer.parseInt(wh[1]);

			char[][] building = new char[h][w];
			for (int i = 0; i < h; i++) {
				building[i] = br.readLine().toCharArray();
			}
			
			int escapeTime = -1;

			Queue<Integer[]> queue = new ArrayDeque<>();
			Queue<Integer[]> fireQueue = new ArrayDeque<>();

			boolean[][] visited = new boolean[h][w];
			int[][] fireMap = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					fireMap[i][j] = -1;
					if (building[i][j] == '@') {
						if(i == 0 || j == 0||i==h-1||j==w-1) {
							escapeTime = 1;
						}
						queue.add(new Integer[] { i, j, 0 });
						visited[i][j] = true;
					} else if (building[i][j] == '*') {
						fireQueue.add(new Integer[] { i, j, 0 });
						fireMap[i][j] = 0;
					}
				}
			}
			if(escapeTime == 1) {
				sb.append(1+"\n"); continue;
			}

			int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			while (!fireQueue.isEmpty()) {
				for (int[] d : delta) {
					int curI = fireQueue.peek()[0] + d[0];
					int curJ = fireQueue.peek()[1] + d[1];
					int curT = fireQueue.peek()[2] + 1;

					if (curI > -1 && curI < h && curJ > -1 && curJ < w && fireMap[curI][curJ] == -1
							&& building[curI][curJ] != '#') {
						fireMap[curI][curJ] = curT;
						fireQueue.add(new Integer[] { curI, curJ, curT });
					}
				}

				fireQueue.poll();
			}
			
			while (!queue.isEmpty()) {
				for (int[] d : delta) {
					int curI = queue.peek()[0] + d[0];
					int curJ = queue.peek()[1] + d[1];
					int curT = queue.peek()[2] + 1;

					if (curI > -1 && curI < h && curJ > -1 && curJ < w && building[curI][curJ] != '#' && visited[curI][curJ] == false) {
						if (fireMap[curI][curJ] == -1 || fireMap[curI][curJ] > curT) {
							visited[curI][curJ] = true;
							queue.add(new Integer[] { curI, curJ, curT });
							if (curI == 0 || curI == h - 1 || curJ == 0 || curJ == w - 1) {
								escapeTime = curT+1;
								break;
							}
						}
					}
				}

				queue.poll();
				if (escapeTime != -1)
					break;
			}

			sb.append(escapeTime == -1 ?  "IMPOSSIBLE\n":escapeTime + "\n");
		}
		System.out.println(sb);
	}
}
