import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 백준 17135 캐슬디펜스 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
				D = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		int maxCnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					int cnt = 0;
					// i, j, k
					for (int m = 0; m < N; m++) {
						for (int n = 0; n < M; n++) {
							if (map[m][n] == '1') {
								queue.add(new int[] { m, n, 0 });
							}
						}
					}
					while (!queue.isEmpty()) {
						getQ(queue, N, i);
						getEnemy(queue, N, i, D);
						getQ(queue, N, j);
						getEnemy(queue, N, j, D);
						getQ(queue, N, k);
						getEnemy(queue, N, k, D);

						Queue<int[]> newQ = new ArrayDeque<>();
						while (!queue.isEmpty()) {
							if (queue.peek()[0] + 1 < N && queue.peek()[2] == 0) {
								newQ.add(new int[] { queue.peek()[0] + 1, queue.peek()[1], queue.peek()[2] });
							}
							if (queue.peek()[2] > 0)
								cnt++;
							queue.poll();
						}
						queue = newQ;
					}
					maxCnt = Math.max(maxCnt, cnt);
				}

			}

		}
		bw.write(String.valueOf(maxCnt));
		bw.flush();
		bw.close();
	}

	static void getQ(Queue<int[]> q, int r1, int c1) {
		List<int[]> list = new ArrayList<>();
		int q1 = q.size();
		for (int i = 0; i < q1; i++)
			list.add(q.poll());

		int[] target = list.get(0);
		for (int[] l : list) {
			if (getDis(l[0], l[1], r1, c1) == getDis(target[0], target[1], r1, c1) && l[1] < target[1]) {
				target = l;
			}
			if (getDis(l[0], l[1], r1, c1) < getDis(target[0], target[1], r1, c1)) {
				target = l;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (target[0] == list.get(i)[0] && target[1] == list.get(i)[1]) {
				q.add(list.get(i));
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (!(target[0] == list.get(i)[0] && target[1] == list.get(i)[1])) {
				q.add(list.get(i));
			}
		}
	}

	static void getEnemy(Queue<int[]> q, int r1, int c1, int d) {
		if (inDis(q.peek()[0], q.peek()[1], r1, c1, d)) {
			q.add(new int[] { q.peek()[0], q.peek()[1], q.peek()[2] + 1 });
			q.poll();
		}
	}

	static int getDis(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static boolean inDis(int r1, int c1, int r2, int c2, int d) {
		return getDis(r1, c1, r2, c2) <= d;
	}
}
