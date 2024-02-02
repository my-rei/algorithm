import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");

		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.add(new Integer[] { n, 0 });
		boolean[] visited = new boolean[100001];

		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int t = queue.peek()[1];

			if (x == k)
				break;

			if (x - 1 >= 0 && visited[x - 1] == false) {
				queue.add(new Integer[] { x - 1, t + 1 });
				visited[x - 1] = true;
			}

			if (x + 1 < 100001 && visited[x + 1] == false) {
				queue.add(new Integer[] { x + 1, t + 1 });
				visited[x + 1] = true;
			}
			if (x * 2 < 100001 && visited[x * 2] == false) {
				queue.add(new Integer[] { 2 * x, t + 1 });
				visited[2 * x] = true;
			}

			queue.poll();
		}

		System.out.println(queue.peek()[1]);
	}
}
