import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int N = Integer.parseInt(nk[0]), K = Integer.parseInt(nk[1]);

		System.out.println(bfs(N, K));

	}

	static int bfs(int N, int K) {
		Queue<int[]> queueW = new ArrayDeque<>();
		Queue<int[]> queueJ = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];

		if (N == K)
			return 0;
		else if (N > K)
			return N - K;
		else {
			visited[N] = true;
			queueW.add(new int[] { N, 0 });
			while (!queueW.isEmpty()) {
				int cur = queueW.peek()[0];
				int curT = queueW.peek()[1];
				//System.out.println(cur);
				queueJ.add(queueW.poll());

				while (!queueJ.isEmpty()) {
					int jCur = queueJ.peek()[0];
					int jCurT = queueJ.peek()[1];
					queueJ.poll();

					int nextCur = jCur * 2;
					if (nextCur == K)
						return jCurT;
					if (nextCur < K * 2 && nextCur < 100001 && !visited[nextCur]) {
						visited[nextCur] = true;
						queueJ.add(new int[] { nextCur, jCurT });
						queueW.add(new int[] {nextCur, jCurT});
					}
				}

				int[] delta = new int[] { cur - 1, cur + 1 };
				for (int d : delta) {
					if (d > -1 && d < 100001 && !visited[d]) {
						if (d == K)
							return curT + 1;
						visited[d] = true;
						queueW.add(new int[] { d, curT + 1 });
					}
				}
			}
		}

		return -1;
	}
}
