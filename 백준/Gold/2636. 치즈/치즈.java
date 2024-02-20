import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map, newMap;
	static int[][] visited;
	static int[] deltaX = { 1, 0, -1, 0 }, deltaY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Queue<Integer[]> queue = new ArrayDeque<>();
		map = new int[R][C];
		newMap = new int[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
					queue.add(new Integer[] { i, j, 0 });
					visited[i][j] = 0;
				} else
					visited[i][j] = Integer.MAX_VALUE;
			}
		}

		while (!queue.isEmpty()) {
			for (int d = 0; d < 4; d++) {
				int nr = queue.peek()[0] + deltaX[d], nc = queue.peek()[1] + deltaY[d];

				if (nr > -1 && nr < R && nc > -1 && nc < C) {
					if (map[nr][nc] == 1 && visited[nr][nc] > queue.peek()[2] + 1) { // 치즈라면
						visited[nr][nc] = queue.peek()[2] + 1;
						newMap[nr][nc] = queue.peek()[2] + 1;
						queue.add(new Integer[] { nr, nc, queue.peek()[2] + 1 });
					} else if (map[nr][nc] == 0 && visited[nr][nc] > queue.peek()[2]) { // 공기거나 이미 녹았다면
						visited[nr][nc] = queue.peek()[2];
						queue.add(new Integer[] { nr, nc, queue.peek()[2] });
					}
				}
			}
			queue.poll();
		}
		int maxTime=0, maxCnt=0;
		for (int i = 0; i < R; i++) {
			//System.out.println(Arrays.toString(newMap[i]));
			for(int j = 0;j<C;j++) {
				if(maxTime < newMap[i][j]) {
					maxTime = newMap[i][j];
					maxCnt = 1;
				} else if (maxTime == newMap[i][j]) {
					maxCnt ++;
				}
			}
		}

		System.out.println(maxTime+"\n"+maxCnt);

	}

}
