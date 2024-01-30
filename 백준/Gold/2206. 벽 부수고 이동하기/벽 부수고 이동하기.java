import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		char[][] map = new char[n][m];
		boolean[][][] visited = new boolean[n][m][2]; // 메모리 초과 문제
		// 벽 뚫은 경우와 뚫지 않은 경우로 visited를 따로 관리한다

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[][] dxy = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		Queue<Integer[]> queue = new LinkedList<>();
		// {x, y, nowCnt, oneCnt}
		queue.add(new Integer[] { 0, 0, 1, 0 });

		int minRoute = -1;

		while (!queue.isEmpty()) {
			int curI = queue.peek()[0];
			int curJ = queue.peek()[1];
			int nowCnt = queue.peek()[2];
			int oneCnt = queue.peek()[3];

			if (curI == n - 1 && curJ == m - 1) {
				minRoute = minRoute == -1 ? nowCnt : Math.min(minRoute, nowCnt);
			} else {
				for (int[] d : dxy) {
					if (curI + d[0] > -1 && curI + d[0] < n && curJ + d[1] > -1 && curJ + d[1] < m
							&& (visited[curI + d[0]][curJ + d[1]][oneCnt] == false)) {
						if (map[curI + d[0]][curJ + d[1]] == '0' && oneCnt == 0) {
							// 뚫지 않아도 되고 뚫지 않았음
							visited[curI + d[0]][curJ + d[1]][oneCnt] = true;
							queue.add(new Integer[] { curI + d[0], curJ + d[1], nowCnt + 1, oneCnt });
						} else if (map[curI + d[0]][curJ + d[1]] == '1' && oneCnt == 0) {
							// 뚫어야 되고 뚫지 않았음
							visited[curI + d[0]][curJ + d[1]][oneCnt] = true;
							queue.add(new Integer[] { curI + d[0], curJ + d[1], nowCnt + 1, oneCnt + 1 });
						} else if (map[curI + d[0]][curJ + d[1]] == '0' && oneCnt == 1) {
							// 뚫지 않아도 되고 뚫었음
							visited[curI + d[0]][curJ + d[1]][oneCnt] = true;
							queue.add(new Integer[] { curI + d[0], curJ + d[1], nowCnt + 1, oneCnt });
						}
					}
				}
			}
			queue.poll();
		}

		System.out.println(minRoute);
	}
}
