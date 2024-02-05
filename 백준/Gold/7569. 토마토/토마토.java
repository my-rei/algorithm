import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mnh = br.readLine().split(" ");
		int M = Integer.parseInt(mnh[0]);
		int N = Integer.parseInt(mnh[1]);
		int H = Integer.parseInt(mnh[2]);

		Integer[][][] tomatoes = new Integer[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		int totalTom = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				String[] temp = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					tomatoes[i][j][k] = Integer.parseInt(temp[k]);
					if (tomatoes[i][j][k]!=-1) totalTom++;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.println(Arrays.toString(tomatoes[i][j]));
			}
		}

		Queue<Integer[]> queue = new ArrayDeque<>();
		// h, n, m, days
		int tCnt = 0;
		for (int i = 0; i < H; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < M; k++) {
					if (tomatoes[i][j][k] == 1) {
						queue.add(new Integer[] { i, j, k, 0 });
						//System.out.println(i + " " + j + " " + k);
						visited[i][j][k] = true;
						tCnt++;
					}
				}

		if (tCnt == totalTom) {
			System.out.println(0);
			return;
		}
		int minDay = 0;
		int[][] delta = new int[][] { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
		while (!queue.isEmpty()) {
			for (int[] d : delta) {
				int curH = queue.peek()[0] + d[0];
				int curJ = queue.peek()[1] + d[1];
				int curI = queue.peek()[2] + d[2];
				if (curH > -1 && curH < H && curJ > -1 && curJ < N && curI > -1 && curI < M
						&& visited[curH][curJ][curI] == false && tomatoes[curH][curJ][curI] == 0) {
					visited[curH][curJ][curI] = true;
					queue.add(new Integer[] { curH, curJ, curI, queue.peek()[3] + 1 });
					tCnt++;
				}
			}

			minDay = Math.max(minDay, queue.peek()[3]);
			//System.out.println(Arrays.toString(queue.peek()));
			queue.poll();
		}

		System.out.println(tCnt == totalTom ? minDay : "-1");

	}
}
