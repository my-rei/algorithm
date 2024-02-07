import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] nmr = br.readLine().split(" ");
		int N = Integer.parseInt(nmr[0]);
		int M = Integer.parseInt(nmr[1]);
		int R = Integer.parseInt(nmr[2]);

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(temp[j]);
		}

		Queue<Integer> queue = new ArrayDeque<>();
		int level = 0;
		while (true) {
			if (Math.min(N - level * 2, M - level * 2) <= 0)
				break;

			for (int j = level; j < M - level - 1; j++)
				queue.add(map[level][j]);
			for (int i = level; i < N - level - 1; i++)
				queue.add(map[i][M - level - 1]);
			for (int j = M - level - 1; j > level; j--)
				queue.add(map[N - level - 1][j]);
			for (int i = N - level - 1; i > level; i--)
				queue.add(map[i][level]);

			for (int i = 0; i < R % queue.size(); i++)
				queue.offer(queue.poll());

			for (int j = level; j < M - level - 1; j++)
				map[level][j] = queue.poll();
			for (int i = level; i < N - level - 1; i++)
				map[i][M - level - 1] = queue.poll();
			for (int j = M - level - 1; j > level; j--)
				map[N - level - 1][j] = queue.poll();
			for (int i = N - level - 1; i > level; i--)
				map[i][level] = queue.poll();

			level += 1;

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++)
//					System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(map[i][j] + " ");
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
