import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;

			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
			}

			Queue<int[]> queue = new ArrayDeque<>();
			int[] dX = new int[] { 1, -1, 0, 0, 1, -1, 1, -1 }, dY = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '1') {
						cnt++;
						map[i][j] = '0';
						queue.add(new int[] { i, j });
						while (!queue.isEmpty()) {
							for (int d = 0; d < 8; d++) {
								int ni = queue.peek()[0] + dX[d];
								int nj = queue.peek()[1] + dY[d];

								if (ni > -1 && ni < h && nj > -1 && nj < w && map[ni][nj] == '1') {
									map[ni][nj] = '0';
									queue.add(new int[] { ni, nj });
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
