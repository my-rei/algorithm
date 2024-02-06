import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] visited;
	static boolean[][] visitedN;
	static char[][] paint;
	static int N, areaY, areaN;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		visitedN = new boolean[N][N];
		paint = new char[N][N];

		for (int i = 0; i < N; i++) {
			paint[i] = br.readLine().toCharArray();
		}

		areaY = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					areaY++;
					dfsY(i, j, paint[i][j]);
				}
			}
		}
		areaN = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedN[i][j]) {
					visitedN[i][j] = true;
					areaN++;
					dfsN(i, j, paint[i][j]);
				}
			}
		}
		System.out.println(areaY + " " + areaN);
	}

	static void dfsY(int curX, int curY, char cur) {
		for (int[] d : delta) {
			int newI = curX + d[0];
			int newJ = curY + d[1];
			if (newI < 0 || newI >= N || newJ < 0 || newJ >= N || visited[newI][newJ])
				continue;
			if (cur == paint[newI][newJ]) {
				visited[newI][newJ] = true;
				dfsY(newI, newJ, cur);
			}
		}

	}

	static void dfsN(int curX, int curY, char cur) {
		for (int[] d : delta) {
			int newI = curX + d[0];
			int newJ = curY + d[1];
			if (newI < 0 || newI >= N || newJ < 0 || newJ >= N || visitedN[newI][newJ])
				continue;
			if (cur == paint[newI][newJ] || (cur == 'R' && paint[newI][newJ] == 'G')
					|| (cur == 'G' && paint[newI][newJ] == 'R')) {
				visitedN[newI][newJ] = true;
				dfsN(newI, newJ, cur);
			}
		}
	}
}
