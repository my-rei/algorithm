import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] delta = { { -2, -1 }, { -1, -2 }, { 2, -1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, 1 }, { 1, 2 } };
		while (T-- > 0) {
			int l = Integer.parseInt(br.readLine());
			String[] now = br.readLine().split(" ");
			String[] goal = br.readLine().split(" ");

			boolean[][] visited = new boolean[l][l];

			Queue<Integer[]> queue = new ArrayDeque<>();

			queue.add(new Integer[] { Integer.parseInt(now[0]), Integer.parseInt(now[1]), 0 });
			visited[Integer.parseInt(now[0])][Integer.parseInt(now[1])] = true;

			while (!queue.isEmpty()) {
				if (queue.peek()[0] == Integer.parseInt(goal[0]) && queue.peek()[1] == Integer.parseInt(goal[1])) {
					sb.append(queue.peek()[2] + "\n");
					break;
				}

				for (int[] d : delta) {
					int tI = queue.peek()[0] + d[0];
					int tJ = queue.peek()[1] + d[1];
					if (tI > -1 && tI < l && tJ > -1 && tJ < l && visited[tI][tJ] == false) {
						queue.add(new Integer[] { tI, tJ, queue.peek()[2] + 1 });
						visited[tI][tJ] = true;
					}
				}

				queue.poll();
			}

		}
		System.out.println(sb);

	}
}
